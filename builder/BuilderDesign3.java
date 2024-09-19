package builder;

/**
 * 思考题：需要定义一个资源池配置类 ResourcePoolConfig。这里的资源池，你可以简单理解为线程池、连接池、对象池等。在这个资源池配置类中，有以下几个成员变量，也就是可配置项。
 * 第三种：使用构建者模式
 */
public class BuilderDesign3 {

    public static void main(String[] args) {
        // ResourcePoolConfig使用举例
        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("doubi")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(12)
                .build();
    }

    public static class ResourcePoolConfig {
        private String name;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        private ResourcePoolConfig(Builder builder) {
            this.name = builder.name;
            this.maxTotal = builder.maxTotal;
            this.maxIdle = builder.maxIdle;
            this.minIdle = builder.minIdle;
        }
        //...省略getter方法...

        //我们将Builder类设计成了ResourcePoolConfig的内部类。
        //我们也可以将Builder类设计成独立的非内部类ResourcePoolConfigBuilder。
        public static class Builder {
            private static final int DEFAULT_MAX_TOTAL = 8;
            private static final int DEFAULT_MAX_IDLE = 8;
            private static final int DEFAULT_MIN_IDLE = 0;

            private String name;
            private int maxTotal = DEFAULT_MAX_TOTAL;
            private int maxIdle = DEFAULT_MAX_IDLE;
            private int minIdle = DEFAULT_MIN_IDLE;

            public ResourcePoolConfig build() {
                // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
                if (maxIdle > maxTotal) {
                    throw new IllegalArgumentException("...");
                }
                if (minIdle > maxTotal || minIdle > maxIdle) {
                    throw new IllegalArgumentException("...");
                }

                return new ResourcePoolConfig(this);
            }

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setMaxTotal(int maxTotal) {
                if (maxTotal <= 0) {
                    throw new IllegalArgumentException("...");
                }
                this.maxTotal = maxTotal;
                return this;
            }

            public Builder setMaxIdle(int maxIdle) {
                if (maxIdle < 0) {
                    throw new IllegalArgumentException("...");
                }
                this.maxIdle = maxIdle;
                return this;
            }

            public Builder setMinIdle(int minIdle) {
                if (minIdle < 0) {
                    throw new IllegalArgumentException("...");
                }
                this.minIdle = minIdle;
                return this;
            }
        }
    }

}
