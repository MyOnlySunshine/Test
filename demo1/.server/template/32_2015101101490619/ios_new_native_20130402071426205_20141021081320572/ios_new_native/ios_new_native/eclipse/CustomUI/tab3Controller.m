#import "tab3Controller.h"
#import "CustomUI_acController.h"
@implementation tab3Controller
@synthesize currentContainer=_currentContainer;
@synthesize lblCITitle=_lblCITitle;
@synthesize name=_name;
@synthesize phone=_phone;
@synthesize email=_email;
@synthesize commits=_commits;
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
[_currentContainer initController:@"tab3Controller"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat tab3width=0;
CGFloat tab3height=0;
tab3width = [[UIScreen mainScreen] applicationFrame].size.width;
tab3height = [[UIScreen mainScreen] applicationFrame].size.height-49;
self.view.frame = CGRectMake(0, 0, tab3width,tab3height);
UMPLayoutView*info=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat infowidth;
CGFloat infoheight;
infowidth = self.view.frame.size.width;
infoheight = self.view.frame.size.height;
info.frame = CGRectMake(0,0,infowidth,infoheight);
info.weightUMPView = 1;
info.paddingLeftUMP = 0;
info.paddingTopUMP = 0;
info.backgroundColor = [UIColor clearColor];
[self.view addLayoutSubView:info];
UMPLayoutView*customer_head=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat customer_headwidth;
CGFloat customer_headheight;
customer_headwidth = info.frame.size.width;
customer_headheight = 42;
customer_head.frame = CGRectMake(0,0,customer_headwidth,customer_headheight);
customer_head.weightUMPView = 0;
customer_head.paddingLeftUMP = 0;
customer_head.paddingTopUMP = 0;
[customer_head setBackgroundImageWithPathForUMP:@"background"];
[info addLayoutSubView:customer_head];
UMPLayoutView*customer_content=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat customer_contentwidth;
CGFloat customer_contentheight;
customer_contentwidth = info.frame.size.width;
customer_contentheight = 0;
customer_content.frame = CGRectMake(0,0,customer_contentwidth,customer_contentheight);
customer_content.weightUMPView = 1;
customer_content.paddingLeftUMP = 5;
customer_content.paddingTopUMP = 0;
customer_content.backgroundColor = [UIColor clearColor];
[info addLayoutSubView:customer_content];
UMPLabel*lblCITitle= [[UMPLabel alloc] initDefault];
CGFloat lblCITitlewidth;
CGFloat lblCITitleheight;
lblCITitlewidth = 0;
lblCITitleheight = customer_head.frame.size.height;
lblCITitle.frame = CGRectMake(0,0,lblCITitlewidth,lblCITitleheight);
lblCITitle.weightUMPView = 1;
lblCITitle.paddingLeftUMP = 0;
lblCITitle.paddingTopUMP = 0;
lblCITitle.title = @"客户详细信息";
lblCITitle.textAlignment = UITextAlignmentCenter;
lblCITitle.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
lblCITitle.font = [UIFont systemFontOfSize:22];
lblCITitle.backgroundColor = [UIColor clearColor];
[customer_head addLayoutSubView:lblCITitle];
UMPLabel*name= [[UMPLabel alloc] initDefault];
CGFloat namewidth;
CGFloat nameheight;
namewidth = customer_content.frame.size.width;
nameheight = 45;
name.frame = CGRectMake(0,0,namewidth,nameheight);
name.weightUMPView = 0;
name.paddingLeftUMP = 0;
name.paddingTopUMP = 0;
name.title = @"彭欣";
name.textAlignment = UITextAlignmentCenter;
name.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
name.font = [UIFont systemFontOfSize:18];
name.backgroundColor = [UIColor clearColor];
[customer_content addLayoutSubView:name];
UMPLabel*phone= [[UMPLabel alloc] initDefault];
CGFloat phonewidth;
CGFloat phoneheight;
phonewidth = customer_content.frame.size.width;
phoneheight = 0;
phone.frame = CGRectMake(0,0,phonewidth,phoneheight);
phone.weightUMPView = 1;
phone.paddingLeftUMP = 0;
phone.paddingTopUMP = 0;
phone.title = @"13811720902";
phone.textAlignment = UITextAlignmentCenter;
phone.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
phone.font = [UIFont systemFontOfSize:16];
phone.backgroundColor = [UIColor clearColor];
[customer_content addLayoutSubView:phone];
UMPLabel*email= [[UMPLabel alloc] initDefault];
CGFloat emailwidth;
CGFloat emailheight;
emailwidth = customer_content.frame.size.width;
emailheight = 0;
email.frame = CGRectMake(0,0,emailwidth,emailheight);
email.weightUMPView = 1;
email.paddingLeftUMP = 0;
email.paddingTopUMP = 0;
email.title = @"penx@yonyou.com";
email.textAlignment = UITextAlignmentCenter;
email.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
email.font = [UIFont systemFontOfSize:16];
email.backgroundColor = [UIColor clearColor];
[customer_content addLayoutSubView:email];
UMPLabel*commits= [[UMPLabel alloc] initDefault];
CGFloat commitswidth;
CGFloat commitsheight;
commitswidth = customer_content.frame.size.width;
commitsheight = 0;
commits.frame = CGRectMake(0,0,commitswidth,commitsheight);
commits.weightUMPView = 1;
commits.paddingLeftUMP = 0;
commits.paddingTopUMP = 0;
commits.title = @"大美女";
commits.textAlignment = UITextAlignmentCenter;
commits.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
commits.font = [UIFont systemFontOfSize:16];
commits.backgroundColor = [UIColor clearColor];
[customer_content addLayoutSubView:commits];
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
