#import <UIKit/UIKit.h>
#import "UMBaseViewController.h"
#import "UMPControls.h"
#import "InvokeDelegate.h"
#import "UMContainer.h"
#import "UMWebViewBase.h"
#import "commonHelper.h"
#import "UMWebViewBase.h"
#import "AppDelegate.h"
@class UMContainer;
@interface tab3Controller: UMBaseViewController
- (void)dispacherEventToWebview:(NSString*)params;
@property (retain) UMContainer *currentContainer;
@property (retain) UMPLabel*lblCITitle;
@property (retain) UMPLabel*name;
@property (retain) UMPLabel*phone;
@property (retain) UMPLabel*email;
@property (retain) UMPLabel*commits;
@end
