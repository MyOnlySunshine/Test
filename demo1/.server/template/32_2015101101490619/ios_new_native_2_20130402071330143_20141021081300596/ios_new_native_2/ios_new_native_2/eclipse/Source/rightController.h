#import <UIKit/UIKit.h>
#import "UMBaseViewController.h"
#import "UMPControls.h"
#import "InvokeDelegate.h"
#import "UMContainer.h"
#import "UMWebViewBase.h"
#import "commonHelper.h"
#import "UMWebViewBase.h"
#import "AppDelegate.h"
#import "CustomUI_lstCustomerListController.h"
@class UMContainer;
@interface rightController: UMBaseViewController
- (void)dispacherEventToWebview:(NSString*)params;
@property (retain) UMContainer *currentContainer;
@property (retain) UMPLabel*lblrgihttitle;
@property (retain) UMPButton*cmdAddCustomer;
@property (retain) lstCustomerListController*lstCustomerList;
@end
