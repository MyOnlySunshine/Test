#import <UIKit/UIKit.h>
#import "UMBaseViewController.h"
#import "UMPControls.h"
#import "InvokeDelegate.h"
#import "UMContainer.h"
#import "UMWebViewBase.h"
#import "commonHelper.h"
#import "UMWebViewBase.h"
#import "AppDelegate.h"
#import "CustomUI_slidingController.h"
@class UMContainer;
@interface tab2Controller: UMBaseViewController
- (void)dispacherEventToWebview:(NSString*)params;
@property (retain) UMContainer *currentContainer;
@property (retain) slidingController*sliding;
@end
