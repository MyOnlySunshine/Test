#import "acController.h"
#import "CustomUI_acController.h"
@implementation acController
@synthesize currentContainer=_currentContainer;
@synthesize ac_title=_ac_title;
@synthesize ac_save=_ac_save;
@synthesize ac_name_lbl=_ac_name_lbl;
@synthesize ac_name=_ac_name;
@synthesize ac_name_lbl2=_ac_name_lbl2;
@synthesize ac_name2=_ac_name2;
@synthesize ac_ok=_ac_ok;
@synthesize web1=_web1;
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
[_currentContainer initController:@"acController"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat acwidth=0;
CGFloat acheight=0;
acwidth = [[UIScreen mainScreen] applicationFrame].size.width;
acheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, acwidth,acheight);
UMPLayoutView*ac_head=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat ac_headwidth;
CGFloat ac_headheight;
ac_headwidth = self.view.frame.size.width;
ac_headheight = 42;
ac_head.frame = CGRectMake(0,0,ac_headwidth,ac_headheight);
ac_head.weightUMPView = 0;
ac_head.paddingLeftUMP = 0;
ac_head.paddingTopUMP = 0;
[ac_head setBackgroundImageWithPathForUMP:@"background"];
[self.view addLayoutSubView:ac_head];
UMPLayoutView*ac_content=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat ac_contentwidth;
CGFloat ac_contentheight;
ac_contentwidth = self.view.frame.size.width;
ac_contentheight = 0;
ac_content.frame = CGRectMake(0,0,ac_contentwidth,ac_contentheight);
ac_content.weightUMPView = 1;
ac_content.paddingLeftUMP = 0;
ac_content.paddingTopUMP = 0;
[ac_content setBackgroundImageWithPathForUMP:@"background"];
[self.view addLayoutSubView:ac_content];
UMPLabel*ac_title= [[UMPLabel alloc] initDefault];
CGFloat ac_titlewidth;
CGFloat ac_titleheight;
ac_titlewidth = 0;
ac_titleheight = ac_head.frame.size.height;
ac_title.frame = CGRectMake(0,0,ac_titlewidth,ac_titleheight);
ac_title.weightUMPView = 1;
ac_title.paddingLeftUMP = 0;
ac_title.paddingTopUMP = 0;
ac_title.title = @"添加客户";
ac_title.textAlignment = UITextAlignmentCenter;
ac_title.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
ac_title.font = [UIFont systemFontOfSize:22];
ac_title.backgroundColor = [UIColor clearColor];
[ac_head addLayoutSubView:ac_title];
UMPButton*ac_save= [[UMPButton alloc] initDefault];
CGFloat ac_savewidth;
CGFloat ac_saveheight;
ac_savewidth = 60;
ac_saveheight = ac_head.frame.size.height;
ac_save.frame = CGRectMake(0,0,ac_savewidth,ac_saveheight);
ac_save.weightUMPView = 0;
ac_save.paddingLeftUMP = 0;
ac_save.paddingTopUMP = 0;
[ac_save setBackgroundImgFromPath:@"2" forState:UMP_Controls_State_Normal];
[ac_save addTarget:self action:@selector(Ok) forControlEvents:UIControlEventTouchUpInside];
[ac_head addLayoutSubView:ac_save];
UMPLayoutView*ac_name_line=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat ac_name_linewidth;
CGFloat ac_name_lineheight;
ac_name_linewidth = ac_content.frame.size.width;
ac_name_lineheight = 50;
ac_name_line.frame = CGRectMake(0,0,ac_name_linewidth,ac_name_lineheight);
ac_name_line.weightUMPView = 0;
ac_name_line.paddingLeftUMP = 0;
ac_name_line.paddingTopUMP = 0;
ac_name_line.backgroundColor = [UIColor clearColor];
[ac_content addLayoutSubView:ac_name_line];
UMPLayoutView*ac_name_line2=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat ac_name_line2width;
CGFloat ac_name_line2height;
ac_name_line2width = ac_content.frame.size.width;
ac_name_line2height = 50;
ac_name_line2.frame = CGRectMake(0,0,ac_name_line2width,ac_name_line2height);
ac_name_line2.weightUMPView = 0;
ac_name_line2.paddingLeftUMP = 0;
ac_name_line2.paddingTopUMP = 0;
ac_name_line2.backgroundColor = [UIColor clearColor];
[ac_content addLayoutSubView:ac_name_line2];
UMPButton*ac_ok= [[UMPButton alloc] initDefault];
CGFloat ac_okwidth;
CGFloat ac_okheight;
ac_okwidth = 100;
ac_okheight = 50;
ac_ok.frame = CGRectMake(0,0,ac_okwidth,ac_okheight);
ac_ok.weightUMPView = 0;
ac_ok.paddingLeftUMP = 220;
ac_ok.paddingTopUMP = 0;
[ac_ok setBackgroundImgFromPath:@"3" forState:UMP_Controls_State_Normal];
[ac_ok addTarget:self action:@selector(Ok) forControlEvents:UIControlEventTouchUpInside];
[ac_content addLayoutSubView:ac_ok];
UMWebViewBase*web1 = [[UMWebViewBase alloc] init];
CGFloat web1width;
CGFloat web1height;
web1width = ac_content.frame.size.width;
web1height = ac_content.frame.size.height;
web1.frame = CGRectMake(0,0,web1width,web1height);
web1.weightUMPView = 1;
web1.paddingLeftUMP = 0;
web1.paddingTopUMP = 0;
[web1 initDefaultEnvironment:(id<InvokeDelegate>)_currentContainer];
NSString*path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"Web/Html/CustomerContent.htm"];
NSURL *htmlUrl = [NSURL fileURLWithPath:path];
NSURLRequest *request = [NSURLRequest requestWithURL:htmlUrl];
[web1 loadRequest:request];
[ac_content addLayoutSubView:web1];
UMPLabel*ac_name_lbl= [[UMPLabel alloc] initDefault];
CGFloat ac_name_lblwidth;
CGFloat ac_name_lblheight;
ac_name_lblwidth = ac_name_line.frame.size.width;
ac_name_lblheight = ac_name_line.frame.size.height;
ac_name_lbl.frame = CGRectMake(0,0,ac_name_lblwidth,ac_name_lblheight);
ac_name_lbl.weightUMPView = 1;
ac_name_lbl.paddingLeftUMP = 0;
ac_name_lbl.paddingTopUMP = 0;
ac_name_lbl.title = @"姓名";
ac_name_lbl.textAlignment = UITextAlignmentCenter;
ac_name_lbl.textColor = [UIColor colorWithRed:0.93333334 green:0.93333334 blue:0.93333334 alpha:1];
ac_name_lbl.backgroundColor = [UIColor clearColor];
[ac_name_line addLayoutSubView:ac_name_lbl];
UMPTextField*ac_name = [[UMPTextField alloc] init];
CGFloat ac_namewidth;
CGFloat ac_nameheight;
ac_namewidth = ac_name_line.frame.size.width;
ac_nameheight = 35;
ac_name.frame = CGRectMake(0,0,ac_namewidth,ac_nameheight);
ac_name.weightUMPView = 1;
ac_name.paddingLeftUMP = 0;
ac_name.paddingTopUMP = 10;
ac_name.delegate = self;
[ac_name_line addLayoutSubView:ac_name];
UMPLabel*ac_name_lbl2= [[UMPLabel alloc] initDefault];
CGFloat ac_name_lbl2width;
CGFloat ac_name_lbl2height;
ac_name_lbl2width = ac_name_line2.frame.size.width;
ac_name_lbl2height = ac_name_line2.frame.size.height;
ac_name_lbl2.frame = CGRectMake(0,0,ac_name_lbl2width,ac_name_lbl2height);
ac_name_lbl2.weightUMPView = 1;
ac_name_lbl2.paddingLeftUMP = 0;
ac_name_lbl2.paddingTopUMP = 0;
ac_name_lbl2.title = @"年龄";
ac_name_lbl2.textAlignment = UITextAlignmentCenter;
ac_name_lbl2.textColor = [UIColor colorWithRed:0.93333334 green:0.93333334 blue:0.93333334 alpha:1];
ac_name_lbl2.backgroundColor = [UIColor clearColor];
[ac_name_line2 addLayoutSubView:ac_name_lbl2];
UMPTextField*ac_name2 = [[UMPTextField alloc] init];
CGFloat ac_name2width;
CGFloat ac_name2height;
ac_name2width = ac_name_line2.frame.size.width;
ac_name2height = 35;
ac_name2.frame = CGRectMake(0,0,ac_name2width,ac_name2height);
ac_name2.weightUMPView = 1;
ac_name2.paddingLeftUMP = 0;
ac_name2.paddingTopUMP = 10;
ac_name2.delegate = self;
[ac_name_line2 addLayoutSubView:ac_name2];
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
