#import "tab2Controller.h"
#import "CustomUI_acController.h"
@implementation tab2Controller
@synthesize currentContainer=_currentContainer;
@synthesize sliding=_sliding;
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
[_currentContainer initController:@"tab2Controller"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat tab2width=0;
CGFloat tab2height=0;
tab2width = [[UIScreen mainScreen] applicationFrame].size.width;
tab2height = [[UIScreen mainScreen] applicationFrame].size.height-49;
self.view.frame = CGRectMake(0, 0, tab2width,tab2height);
CustomUI_slidingController*sliding=[[CustomUI_slidingController alloc] initWithNibName:nil bundle:nil];
[self.view addLayoutSubView:sliding.view];
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
