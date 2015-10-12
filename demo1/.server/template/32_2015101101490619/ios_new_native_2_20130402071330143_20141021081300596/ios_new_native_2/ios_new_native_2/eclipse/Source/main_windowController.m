#import "main_windowController.h"
#import "CustomUI_acController.h"
@implementation main_windowController
@synthesize currentContainer=_currentContainer;
@synthesize tabcontrol=_tabcontrol;
static NSString* baseHtmlResourcePath=@"Web/Html";
static UMWebViewBase* webView;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
AppDelegate* appDelegate = [[UIApplication sharedApplication] delegate];
_currentContainer=[appDelegate currentContainer];
[_currentContainer initController:@"CustomerWindowModel"];
[_currentContainer initController:@"CustomerContentController"];
[_currentContainer initController:@"CustomerContentControllerEx"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat main_windowwidth=0;
CGFloat main_windowheight=0;
main_windowwidth = [[UIScreen mainScreen] applicationFrame].size.width;
main_windowheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, main_windowwidth,main_windowheight);
_tabcontrol=[[CustomUI_tabcontrolController alloc] initWithNibName:nil bundle:nil];
UIView*viewOfCustomUI_tabcontrolController=_tabcontrol.view;
CGFloat viewOfCustomUI_tabcontrolControllerwidth;
CGFloat viewOfCustomUI_tabcontrolControllerheight;
viewOfCustomUI_tabcontrolControllerwidth = self.view.frame.size.width;
viewOfCustomUI_tabcontrolControllerheight = self.view.frame.size.height;
viewOfCustomUI_tabcontrolController.frame = CGRectMake(0,0,viewOfCustomUI_tabcontrolControllerwidth,viewOfCustomUI_tabcontrolControllerheight);
viewOfCustomUI_tabcontrolController.weightUMPView = 0;
viewOfCustomUI_tabcontrolController.paddingLeftUMP = 0;
viewOfCustomUI_tabcontrolController.paddingTopUMP = 0;
viewOfCustomUI_tabcontrolController.paddingRightUMP = 0;
viewOfCustomUI_tabcontrolController.paddingBottomUMP = 0;
[viewOfCustomUI_tabcontrolController setBackgroundImageWithPathForUMP:@"tabbar"];
[(UMPLayoutView*)self.view addLayoutSubView:_tabcontrol.view];
}
- (void)viewWillAppear:(BOOL)animated
{
[SysContext getInstance].CurrentViewController = self;
[super viewWillAppear:animated];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
- (void)dispacherEventToWeView:(NSString*)params
{
[webView.m_jsBridge callHandler:@"eventdispacher" data:params];
[_currentContainer DataBinding:self jsonData:params];
}
- (IBAction)nextPage{
CustomUI_acController* next = [[CustomUI_acController alloc] initWithNibName:nil bundle:nil];
[self.view addSubview:next.view];
}
- (IBAction)Close{
[self.view removeFromSuperview];
}
- (IBAction)Ok{
}
@end
