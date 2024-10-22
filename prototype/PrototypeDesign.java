package prototype;

public class PrototypeDesign {

    public static void main(String[] args) {
        new PrototypeDesign().test();
    }

    private void testNew() {
        EmailNew email = new EmailNew("邮件标题", "邮件内容，哈哈哈..", new Attachment("附件标题", "文档", 45987));
        System.out.println(email.display());
        EmailNew copyEmail = (EmailNew) email.cloneMe();
        System.out.println("邮件复制状态：" + (email != copyEmail && email.equals(copyEmail) ? "成功" : "失败") );
        Attachment attachment = email.getAttachment();
        Attachment copyAttachment = copyEmail.getAttachment();
        if(attachment.equals(copyAttachment)) {
            System.out.println("邮件附件内容一致");
        }
        if(attachment == copyAttachment) {
            System.out.println("邮件附件未复制");
        } else {
            System.out.println("邮件附件已复制");
        }
    }

    private void test() {
        Email email = new Email("邮件标题", "邮件内容，哈哈哈..", new Attachment("附件标题", "文档", 45987));
        System.out.println(email.display());
        Email copyEmail = (Email) email.cloneMe();
        System.out.println("邮件复制状态：" + (email != copyEmail && email.equals(copyEmail) ? "成功" : "失败") );
        Attachment attachment = email.getAttachment();
        Attachment copyAttachment = copyEmail.getAttachment();
        if(attachment.equals(copyAttachment)) {
            System.out.println("邮件附件内容一致");
        }
        if(attachment == copyAttachment) {
            System.out.println("邮件附件未复制");
        } else {
            System.out.println("邮件附件已复制");
        }
    }

    public class Prototype implements Cloneable {
        public Prototype cloneMe() {
            Prototype prototype = null;
            try {
                prototype = (Prototype) this.clone();
            } catch (CloneNotSupportedException exception) {
            }
            return prototype;
        }
    }

    public class Attachment extends Prototype {

        // 附件名字
        private String name;
        // 附件文档类型
        private String type;
        // 附件大小
        private long length;

        public Attachment(String name, String type, long length) {
            super();
            this.name = name;
            this.type = type;
            this.length = length;
        }

        public void download() {
            System.out.println("下载了附件：" + name);
        }

        public String display() {
            return "Attachment [name=" + name + ", type=" + type + ", length=" + length + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Attachment a = (Attachment) obj;
            if(a.name.equals(name) && a.type.equals(type) && a.length == length) {
                return true;
            }
            return false;
        }
    }


    public class Email extends Prototype {

        // 标题
        private String title;
        // 内容
        private String content;
        // 附件
        private Attachment attachment;

        public Email(String title, String content, Attachment attachment) {
            super();
            this.title = title;
            this.content = content;
            this.attachment = attachment;
        }

        public String display() {
            return "Email [title=" + title + ", content=" + content + ", attachment=" + attachment.display();
        }

        public Attachment getAttachment() {
            return attachment;
        }

        @Override
        public boolean equals(Object obj) {
            Email e = (Email) obj;
            if(e.title.equals(title) && e.content.equals(content) && e.attachment.equals(attachment)) {
                return true;
            }
            return false;
        }
    }

    public class EmailNew extends Prototype {

        // 标题
        private String title;
        // 内容
        private String content;
        // 附件
        private Attachment attachment;

        public EmailNew(String title, String content, Attachment attachment) {
            super();
            this.title = title;
            this.content = content;
            this.attachment = attachment;
        }

        public String display() {
            return "EmailNew [title=" + title + ", content=" + content + ", attachment=" + attachment.display();
        }

        public Attachment getAttachment() {
            return attachment;
        }

        @Override
        public boolean equals(Object obj) {
            EmailNew e = (EmailNew) obj;
            if(e.title.equals(title) && e.content.equals(content) && e.attachment.equals(attachment)) {
                return true;
            }
            return false;
        }

        @Override
        public EmailNew cloneMe() {
            EmailNew e = (EmailNew) super.cloneMe();
            e.attachment = (Attachment) attachment.cloneMe();
            return e;
        }
    }



}
