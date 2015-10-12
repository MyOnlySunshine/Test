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
@interface tab1Controller: UMBaseViewController
- (void)dispacherEventToWebview:(NSString*)params;
@property (retain) UMContainer *currentContainer;
@property (retain) UMPLabel*main_title;
@property (retain) UMPButton*main_next;
@property (retain) UMPButton*main_customer;
@property (retain) UMPButton*main_product;
@property (retain) UMPButton*main_order;
@property (retain) UMPButton*main_action;
@property (retain) UMPButton*main_contract;
@property (retain) UMPButton*main_work;
@property (retain) UMPButton*main_lines;
@property (retain) UMPButton*main_chance;
@property (retain) UMPButton*main_knowdge;
@end
