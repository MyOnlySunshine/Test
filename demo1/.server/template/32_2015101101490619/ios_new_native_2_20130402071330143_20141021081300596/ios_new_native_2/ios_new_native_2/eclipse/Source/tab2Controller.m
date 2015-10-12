#import "tab2Controller.h"
#import "CustomUI_acController.h"
@implementation tab2Controller
@synthesize currentContainer=_currentContainer;
@synthesize sliding=_sliding;
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
CGFloat tab2width=0;
CGFloat tab2height=0;
tab2width = [[UIScreen mainScreen] applicationFrame].size.width;
tab2height = [[UIScreen mainScreen] applicationFrame].size.height-49;
self.view.frame = CGRectMake(0, 0, tab2width,tab2height);
_sliding=[[CustomUI_slidingController alloc] initWithNibName:nil bundle:nil];
[(UMPLayoutView*)self.view addLayoutSubView:_sliding.view];
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
