#import "YcToastPlugin.h"
#import <yc_toast/yc_toast-Swift.h>

@implementation YcToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftYcToastPlugin registerWithRegistrar:registrar];
}
@end
