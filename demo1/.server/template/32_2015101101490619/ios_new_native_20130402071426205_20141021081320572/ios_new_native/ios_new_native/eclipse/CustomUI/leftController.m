#import "leftController.h"
#import "CustomUI_acController.h"
@implementation leftController
@synthesize currentContainer=_currentContainer;
@synthesize lbllefttitle=_lbllefttitle;
static NSString* baseHtmlResourcePath=@"Web/Html";
UMWebViewBase* webView;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
AppDelegate* appDelegate = [[UIApplication sharedApplication] delegate];
_currentContainer=[appDelegate currentContainer];
[_currentContainer initController:@"leftController"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat leftwidth=0;
CGFloat leftheight=0;
leftwidth = 320;
leftheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, leftwidth,leftheight);
UMPLayoutView*lefthead=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat leftheadwidth;
CGFloat leftheadheight;
leftheadwidth = self.view.frame.size.width;
leftheadheight = 42;
lefthead.frame = CGRectMake(0,0,leftheadwidth,leftheadheight);
lefthead.weightUMPView = 0;
lefthead.paddingLeftUMP = 0;
lefthead.paddingTopUMP = 0;
[lefthead setBackgroundImageWithPathForUMP:@"background"];
[self.view addLayoutSubView:lefthead];
CustomUI_CustomerTypeController*CustomerType=[[CustomUI_CustomerTypeController alloc] initWithNibName:nil bundle:nil];
[self.view addLayoutSubView:CustomerType.view];
UMPLabel*lbllefttitle= [[UMPLabel alloc] initDefault];
CGFloat lbllefttitlewidth;
CGFloat lbllefttitleheight;
lbllefttitlewidth = 0;
lbllefttitleheight = lefthead.frame.size.height;
lbllefttitle.frame = CGRectMake(0,0,lbllefttitlewidth,lbllefttitleheight);
lbllefttitle.weightUMPView = 1;
lbllefttitle.paddingLeftUMP = 0;
lbllefttitle.paddingTopUMP = 0;
lbllefttitle.title = @"客户分类";
lbllefttitle.textAlignment = UITextAlignmentCenter;
lbllefttitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
lbllefttitle.font = [UIFont systemFontOfSize:22];
lbllefttitle.backgroundColor = [UIColor clearColor];
[lefthead addLayoutSubView:lbllefttitle];
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
- (void)dispacherEventToWebView:(NSString*)params
{
[webView.m_jsBridge callHandler:@"eventdispacher" data:params];
[_currentContainer DataBinding:self jsonData:params];
}
- (IBAction)nextPage{
CustomUI_acController* next = [[CustomUI_acController alloc] initWithNibName:nil bundle:nil];
[self.view addSubview:next.view];
}
- (IBAction)Close{
}
- (IBAction)Ok{
}
@end
