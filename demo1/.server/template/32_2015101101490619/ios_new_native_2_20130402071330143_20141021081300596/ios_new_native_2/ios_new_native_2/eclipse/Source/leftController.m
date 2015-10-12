#import "leftController.h"
#import "CustomUI_acController.h"
@implementation leftController
@synthesize currentContainer=_currentContainer;
@synthesize lbllefttitle=_lbllefttitle;
@synthesize lstCustomerType=_lstCustomerType;
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
self.view.backgroundColor = [UIColor colorWithRed:0.2 green:0.2 blue:0.2 alpha:1];
CGFloat leftwidth=0;
CGFloat leftheight=0;
leftwidth = 320;
leftheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, leftwidth,leftheight);
UMPLayoutView*lefthead=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat leftheadwidth;
CGFloat leftheadheight;
leftheadwidth = self.view.frame.size.width;
leftheadheight = 55;
lefthead.frame = CGRectMake(0,0,leftheadwidth,leftheadheight);
lefthead.weightUMPView = 0;
lefthead.paddingLeftUMP = 0;
lefthead.paddingTopUMP = 0;
lefthead.paddingRightUMP = 0;
lefthead.paddingBottomUMP = 0;
[lefthead setBackgroundImageWithPathForUMP:@"nav"];
[(UMPLayoutView*)self.view addLayoutSubView:lefthead];
_lstCustomerType=[[CustomUI_lstCustomerTypeController alloc] initWithNibName:nil bundle:nil];
[(UMPLayoutView*)self.view addLayoutSubView:_lstCustomerType.view];
_lbllefttitle= [[UMPLabel alloc] initDefault];
CGFloat _lbllefttitlewidth;
CGFloat _lbllefttitleheight;
_lbllefttitlewidth = 0;
_lbllefttitleheight = lefthead.frame.size.height;
_lbllefttitle.frame = CGRectMake(0,0,_lbllefttitlewidth,_lbllefttitleheight);
_lbllefttitle.weightUMPView = 1;
_lbllefttitle.paddingLeftUMP = 5;
_lbllefttitle.paddingTopUMP = 0;
_lbllefttitle.paddingRightUMP = 0;
_lbllefttitle.paddingBottomUMP = 0;
_lbllefttitle.alignUMP = 2;
_lbllefttitle.title = @"客户分类";
_lbllefttitle.textAlignment = UITextAlignmentCenter;
_lbllefttitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
_lbllefttitle.font = [UIFont systemFontOfSize:22];
_lbllefttitle.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)lefthead addLayoutSubView:_lbllefttitle];
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
