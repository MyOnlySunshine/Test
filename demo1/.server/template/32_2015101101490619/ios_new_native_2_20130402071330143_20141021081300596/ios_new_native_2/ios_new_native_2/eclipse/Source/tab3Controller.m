#import "tab3Controller.h"
#import "CustomUI_acController.h"
@implementation tab3Controller
@synthesize currentContainer=_currentContainer;
@synthesize lblCITitle=_lblCITitle;
@synthesize info_msg=_info_msg;
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
self.view.backgroundColor = [UIColor colorWithRed:0.8666667 green:0.8666667 blue:0.8666667 alpha:1];
CGFloat tab3width=0;
CGFloat tab3height=0;
tab3width = [[UIScreen mainScreen] applicationFrame].size.width;
tab3height = [[UIScreen mainScreen] applicationFrame].size.height-49;
self.view.frame = CGRectMake(0, 0, tab3width,tab3height);
UMPLayoutView*info=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat infowidth;
CGFloat infoheight;
infowidth = self.view.frame.size.width;
infoheight = 0;
info.frame = CGRectMake(0,0,infowidth,infoheight);
info.weightUMPView = 1;
info.paddingLeftUMP = 0;
info.paddingTopUMP = 0;
info.paddingRightUMP = 0;
info.paddingBottomUMP = 0;
info.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)self.view addLayoutSubView:info];
UMPLayoutView*customer_head=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat customer_headwidth;
CGFloat customer_headheight;
customer_headwidth = info.frame.size.width;
customer_headheight = 55;
customer_head.frame = CGRectMake(0,0,customer_headwidth,customer_headheight);
customer_head.weightUMPView = 0;
customer_head.paddingLeftUMP = 0;
customer_head.paddingTopUMP = 0;
customer_head.paddingRightUMP = 0;
customer_head.paddingBottomUMP = 0;
[customer_head setBackgroundImageWithPathForUMP:@"nav"];
[(UMPLayoutView*)info addLayoutSubView:customer_head];
UMPLayoutView*customer_content=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat customer_contentwidth;
CGFloat customer_contentheight;
customer_contentwidth = 300;
customer_contentheight = 324;
customer_content.frame = CGRectMake(0,0,customer_contentwidth,customer_contentheight);
customer_content.weightUMPView = 0;
customer_content.paddingLeftUMP = 5;
customer_content.paddingTopUMP = 0;
customer_content.paddingRightUMP = 0;
customer_content.paddingBottomUMP = 0;
customer_content.alignUMP = 2;
customer_content.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)info addLayoutSubView:customer_content];
_lblCITitle= [[UMPLabel alloc] initDefault];
CGFloat _lblCITitlewidth;
CGFloat _lblCITitleheight;
_lblCITitlewidth = 0;
_lblCITitleheight = customer_head.frame.size.height;
_lblCITitle.frame = CGRectMake(0,0,_lblCITitlewidth,_lblCITitleheight);
_lblCITitle.weightUMPView = 1;
_lblCITitle.paddingLeftUMP = 5;
_lblCITitle.paddingTopUMP = 0;
_lblCITitle.paddingRightUMP = 0;
_lblCITitle.paddingBottomUMP = 0;
_lblCITitle.alignUMP = 2;
_lblCITitle.title = @"客户详细信息";
_lblCITitle.textAlignment = UITextAlignmentCenter;
_lblCITitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
_lblCITitle.font = [UIFont systemFontOfSize:22];
_lblCITitle.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)customer_head addLayoutSubView:_lblCITitle];
_info_msg= [[UMPButton alloc] initDefault];
CGFloat _info_msgwidth;
CGFloat _info_msgheight;
_info_msgwidth = customer_content.frame.size.width;
_info_msgheight = 1000;
_info_msg.frame = CGRectMake(0,0,_info_msgwidth,_info_msgheight);
_info_msg.weightUMPView = 0;
_info_msg.paddingLeftUMP = 0;
_info_msg.paddingTopUMP = 0;
_info_msg.paddingRightUMP = 0;
_info_msg.paddingBottomUMP = 0;
[_info_msg setBackgroundImgFromPath:@"msg" forState:UMP_Controls_State_Normal];
[_info_msg setImgFromPath:@"msg" forState:UMP_Controls_State_Normal];
[(UMPLayoutView*)customer_content addLayoutSubView:_info_msg];
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
