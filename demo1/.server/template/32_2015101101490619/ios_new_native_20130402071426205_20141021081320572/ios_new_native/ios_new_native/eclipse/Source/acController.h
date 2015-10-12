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
@interface acController: UMBaseViewController
- (void)dispacherEventToWebview:(NSString*)params;
@property (retain) UMContainer *currentContainer;
@property (retain) UMPLabel*ac_title;
@property (retain) UMPButton*ac_save;
@property (retain) UMPLabel*ac_name_lbl;
@property (retain) UMPTextField*ac_name;
@property (retain) UMPLabel*ac_name_lbl2;
@property (retain) UMPTextField*ac_name2;
@property (retain) UMPButton*ac_ok;
@property (retain) UMWebViewBase*web1;
@end
