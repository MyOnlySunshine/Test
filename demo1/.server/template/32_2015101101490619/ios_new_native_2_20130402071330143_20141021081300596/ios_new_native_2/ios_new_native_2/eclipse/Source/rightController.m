#import "rightController.h"
#import "CustomUI_acController.h"
@implementation rightController
@synthesize currentContainer=_currentContainer;
@synthesize lblrgihttitle=_lblrgihttitle;
@synthesize cmdAddCustomer=_cmdAddCustomer;
@synthesize lstCustomerList=_lstCustomerList;
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
self.view.backgroundColor = [UIColor colorWithRed:0.99215686 green:0.98039216 blue:0.8509804 alpha:1];
CGFloat rightwidth=0;
CGFloat rightheight=0;
rightwidth = 320;
rightheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, rightwidth,rightheight);
UMPLayoutView*righthead=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat rightheadwidth;
CGFloat rightheadheight;
rightheadwidth = self.view.frame.size.width;
rightheadheight = 55;
righthead.frame = CGRectMake(0,0,rightheadwidth,rightheadheight);
righthead.weightUMPView = 0;
righthead.paddingLeftUMP = 0;
righthead.paddingTopUMP = 0;
righthead.paddingRightUMP = 0;
righthead.paddingBottomUMP = 0;
[righthead setBackgroundImageWithPathForUMP:@"nav"];
[(UMPLayoutView*)self.view addLayoutSubView:righthead];
_lstCustomerList=[[CustomUI_lstCustomerListController alloc] initWithNibName:nil bundle:nil];
[(UMPLayoutView*)self.view addLayoutSubView:_lstCustomerList.view];
_lblrgihttitle= [[UMPLabel alloc] initDefault];
CGFloat _lblrgihttitlewidth;
CGFloat _lblrgihttitleheight;
_lblrgihttitlewidth = 0;
_lblrgihttitleheight = righthead.frame.size.height;
_lblrgihttitle.frame = CGRectMake(0,0,_lblrgihttitlewidth,_lblrgihttitleheight);
_lblrgihttitle.weightUMPView = 1;
_lblrgihttitle.paddingLeftUMP = 5;
_lblrgihttitle.paddingTopUMP = 0;
_lblrgihttitle.paddingRightUMP = 0;
_lblrgihttitle.paddingBottomUMP = 0;
_lblrgihttitle.alignUMP = 2;
_lblrgihttitle.title = @"客户列表";
_lblrgihttitle.textAlignment = UITextAlignmentCenter;
_lblrgihttitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
_lblrgihttitle.font = [UIFont systemFontOfSize:22];
_lblrgihttitle.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)righthead addLayoutSubView:_lblrgihttitle];
_cmdAddCustomer= [[UMPButton alloc] initDefault];
CGFloat _cmdAddCustomerwidth;
CGFloat _cmdAddCustomerheight;
_cmdAddCustomerwidth = 50;
_cmdAddCustomerheight = 45;
_cmdAddCustomer.frame = CGRectMake(0,0,_cmdAddCustomerwidth,_cmdAddCustomerheight);
_cmdAddCustomer.weightUMPView = 0;
_cmdAddCustomer.paddingLeftUMP = 0;
_cmdAddCustomer.paddingTopUMP = 0;
_cmdAddCustomer.paddingRightUMP = 0;
_cmdAddCustomer.paddingBottomUMP = 0;
_cmdAddCustomer.alignUMP = 2;
[_cmdAddCustomer setBackgroundImgFromPath:@"plus" forState:UMP_Controls_State_Normal];
[_cmdAddCustomer setImgFromPath:@"plus" forState:UMP_Controls_State_Normal];
[_cmdAddCustomer addTarget:self action:@selector(AddCustomer) forControlEvents:UIControlEventTouchUpInside];
[(UMPLayoutView*)righthead addLayoutSubView:_cmdAddCustomer];
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
