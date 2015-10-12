#import "rightController.h"
#import "CustomUI_acController.h"
@implementation rightController
@synthesize currentContainer=_currentContainer;
@synthesize lblrgihttitle=_lblrgihttitle;
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
[_currentContainer initController:@"rightController"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat rightwidth=0;
CGFloat rightheight=0;
rightwidth = 320;
rightheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, rightwidth,rightheight);
UMPLayoutView*righthead=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat rightheadwidth;
CGFloat rightheadheight;
rightheadwidth = self.view.frame.size.width;
rightheadheight = 42;
righthead.frame = CGRectMake(0,0,rightheadwidth,rightheadheight);
righthead.weightUMPView = 0;
righthead.paddingLeftUMP = 0;
righthead.paddingTopUMP = 0;
[righthead setBackgroundImageWithPathForUMP:@"background"];
[self.view addLayoutSubView:righthead];
CustomUI_CustomerListController*CustomerList=[[CustomUI_CustomerListController alloc] initWithNibName:nil bundle:nil];
[self.view addLayoutSubView:CustomerList.view];
UMPLabel*lblrgihttitle= [[UMPLabel alloc] initDefault];
CGFloat lblrgihttitlewidth;
CGFloat lblrgihttitleheight;
lblrgihttitlewidth = 0;
lblrgihttitleheight = righthead.frame.size.height;
lblrgihttitle.frame = CGRectMake(0,0,lblrgihttitlewidth,lblrgihttitleheight);
lblrgihttitle.weightUMPView = 1;
lblrgihttitle.paddingLeftUMP = 0;
lblrgihttitle.paddingTopUMP = 0;
lblrgihttitle.title = @"客户列表";
lblrgihttitle.textAlignment = UITextAlignmentCenter;
lblrgihttitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
lblrgihttitle.font = [UIFont systemFontOfSize:22];
lblrgihttitle.backgroundColor = [UIColor clearColor];
[righthead addLayoutSubView:lblrgihttitle];
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
