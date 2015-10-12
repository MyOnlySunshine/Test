#import "acController.h"
#import "CustomUI_acController.h"
@implementation acController
@synthesize currentContainer=_currentContainer;
@synthesize ac_title=_ac_title;
@synthesize ac_save=_ac_save;
@synthesize ac_image=_ac_image;
@synthesize ac_name_lbl=_ac_name_lbl;
@synthesize ac_name_pos=_ac_name_pos;
@synthesize clientJSObject=_clientJSObject;
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
self.view.backgroundColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
CGFloat acwidth=0;
CGFloat acheight=0;
acwidth = [[UIScreen mainScreen] applicationFrame].size.width;
acheight = [[UIScreen mainScreen] applicationFrame].size.height;
self.view.frame = CGRectMake(0, 0, acwidth,acheight);
UMPLayoutView*ac_head=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat ac_headwidth;
CGFloat ac_headheight;
ac_headwidth = self.view.frame.size.width;
ac_headheight = 55;
ac_head.frame = CGRectMake(0,0,ac_headwidth,ac_headheight);
ac_head.weightUMPView = 0;
ac_head.paddingLeftUMP = 0;
ac_head.paddingTopUMP = 0;
ac_head.paddingRightUMP = 0;
ac_head.paddingBottomUMP = 0;
[ac_head setBackgroundImageWithPathForUMP:@"nav"];
[(UMPLayoutView*)self.view addLayoutSubView:ac_head];
UMPLayoutView*ac_content=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat ac_contentwidth;
CGFloat ac_contentheight;
ac_contentwidth = self.view.frame.size.width;
ac_contentheight = 0;
ac_content.frame = CGRectMake(0,0,ac_contentwidth,ac_contentheight);
ac_content.weightUMPView = 1;
ac_content.paddingLeftUMP = 0;
ac_content.paddingTopUMP = 0;
ac_content.paddingRightUMP = 0;
ac_content.paddingBottomUMP = 0;
ac_content.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)self.view addLayoutSubView:ac_content];
_ac_title= [[UMPLabel alloc] initDefault];
CGFloat _ac_titlewidth;
CGFloat _ac_titleheight;
_ac_titlewidth = 0;
_ac_titleheight = ac_head.frame.size.height;
_ac_title.frame = CGRectMake(0,0,_ac_titlewidth,_ac_titleheight);
_ac_title.weightUMPView = 1;
_ac_title.paddingLeftUMP = 5;
_ac_title.paddingTopUMP = 0;
_ac_title.paddingRightUMP = 0;
_ac_title.paddingBottomUMP = 0;
_ac_title.alignUMP = 2;
_ac_title.title = @"添加客户";
_ac_title.textAlignment = UITextAlignmentCenter;
_ac_title.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
_ac_title.font = [UIFont systemFontOfSize:22];
_ac_title.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)ac_head addLayoutSubView:_ac_title];
_ac_save= [[UMPButton alloc] initDefault];
CGFloat _ac_savewidth;
CGFloat _ac_saveheight;
_ac_savewidth = 50;
_ac_saveheight = 45;
_ac_save.frame = CGRectMake(0,0,_ac_savewidth,_ac_saveheight);
_ac_save.weightUMPView = 0;
_ac_save.paddingLeftUMP = 0;
_ac_save.paddingTopUMP = 0;
_ac_save.paddingRightUMP = 0;
_ac_save.paddingBottomUMP = 0;
_ac_save.alignUMP = 2;
[_ac_save setBackgroundImgFromPath:@"next" forState:UMP_Controls_State_Normal];
[_ac_save setImgFromPath:@"next" forState:UMP_Controls_State_Normal];
[_ac_save addTarget:self action:@selector(Close) forControlEvents:UIControlEventTouchUpInside];
[(UMPLayoutView*)ac_head addLayoutSubView:_ac_save];
UMPLayoutView*ac_name_line=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat ac_name_linewidth;
CGFloat ac_name_lineheight;
ac_name_linewidth = ac_content.frame.size.width;
ac_name_lineheight = ac_content.frame.size.height;
ac_name_line.frame = CGRectMake(0,0,ac_name_linewidth,ac_name_lineheight);
ac_name_line.weightUMPView = 1;
ac_name_line.paddingLeftUMP = 0;
ac_name_line.paddingTopUMP = 0;
ac_name_line.paddingRightUMP = 0;
ac_name_line.paddingBottomUMP = 0;
ac_name_line.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)ac_content addLayoutSubView:ac_name_line];
_clientJSObject = [[UMWebViewBase alloc] init];
webView=_clientJSObject;
CGFloat _clientJSObjectwidth;
CGFloat _clientJSObjectheight;
_clientJSObjectwidth = ac_content.frame.size.width;
_clientJSObjectheight = 0;
_clientJSObject.frame = CGRectMake(0,0,_clientJSObjectwidth,_clientJSObjectheight);
_clientJSObject.weightUMPView = 4;
_clientJSObject.paddingLeftUMP = 0;
_clientJSObject.paddingTopUMP = 0;
_clientJSObject.paddingRightUMP = 0;
_clientJSObject.paddingBottomUMP = 0;
[_clientJSObject initDefaultEnvironment:(id<InvokeDelegate>)_currentContainer];
NSString*path = [[[NSBundle mainBundle] resourcePath] stringByAppendingPathComponent:@"Web/Html/CustomerContent.html"];
NSURL *htmlUrl = [NSURL fileURLWithPath:path];
NSURLRequest *request = [NSURLRequest requestWithURL:htmlUrl];
[_clientJSObject loadRequest:request];
[(UMPLayoutView*)ac_content addLayoutSubView:_clientJSObject];
_ac_image= [[UMPButton alloc] initDefault];
CGFloat _ac_imagewidth;
CGFloat _ac_imageheight;
_ac_imagewidth = 65;
_ac_imageheight = ac_name_line.frame.size.height;
_ac_image.frame = CGRectMake(0,0,_ac_imagewidth,_ac_imageheight);
_ac_image.weightUMPView = 0;
_ac_image.paddingLeftUMP = 0;
_ac_image.paddingTopUMP = 0;
_ac_image.paddingRightUMP = 0;
_ac_image.paddingBottomUMP = 0;
[_ac_image setBackgroundImgFromPath:@"fm" forState:UMP_Controls_State_Normal];
[_ac_image setImgFromPath:@"fm" forState:UMP_Controls_State_Normal];
[(UMPLayoutView*)ac_name_line addLayoutSubView:_ac_image];
UMPLayoutView*ac_name_line_1=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat ac_name_line_1width;
CGFloat ac_name_line_1height;
ac_name_line_1width = 0;
ac_name_line_1height = ac_name_line.frame.size.height;
ac_name_line_1.frame = CGRectMake(0,0,ac_name_line_1width,ac_name_line_1height);
ac_name_line_1.weightUMPView = 1;
ac_name_line_1.paddingLeftUMP = 10;
ac_name_line_1.paddingTopUMP = 0;
ac_name_line_1.paddingRightUMP = 0;
ac_name_line_1.paddingBottomUMP = 0;
ac_name_line_1.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)ac_name_line addLayoutSubView:ac_name_line_1];
_ac_name_lbl= [[UMPLabel alloc] initDefault];
CGFloat _ac_name_lblwidth;
CGFloat _ac_name_lblheight;
_ac_name_lblwidth = ac_name_line_1.frame.size.width;
_ac_name_lblheight = 0;
_ac_name_lbl.frame = CGRectMake(0,0,_ac_name_lblwidth,_ac_name_lblheight);
_ac_name_lbl.weightUMPView = 1;
_ac_name_lbl.paddingLeftUMP = 0;
_ac_name_lbl.paddingTopUMP = 0;
_ac_name_lbl.paddingRightUMP = 0;
_ac_name_lbl.paddingBottomUMP = 0;
_ac_name_lbl.alignUMP = 1;
_ac_name_lbl.title = @"张心雨";
_ac_name_lbl.textAlignment = UITextAlignmentLeft;
_ac_name_lbl.textColor = [UIColor colorWithRed:0.06666667 green:0.06666667 blue:0.06666667 alpha:1];
_ac_name_lbl.font = [UIFont systemFontOfSize:22];
_ac_name_lbl.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)ac_name_line_1 addLayoutSubView:_ac_name_lbl];
_ac_name_pos= [[UMPLabel alloc] initDefault];
CGFloat _ac_name_poswidth;
CGFloat _ac_name_posheight;
_ac_name_poswidth = ac_name_line_1.frame.size.width;
_ac_name_posheight = 0;
_ac_name_pos.frame = CGRectMake(0,0,_ac_name_poswidth,_ac_name_posheight);
_ac_name_pos.weightUMPView = 1;
_ac_name_pos.paddingLeftUMP = 0;
_ac_name_pos.paddingTopUMP = 0;
_ac_name_pos.paddingRightUMP = 0;
_ac_name_pos.paddingBottomUMP = 0;
_ac_name_pos.alignUMP = 1;
_ac_name_pos.title = @"部门经理";
_ac_name_pos.textAlignment = UITextAlignmentLeft;
_ac_name_pos.textColor = [UIColor colorWithRed:0.06666667 green:0.06666667 blue:0.06666667 alpha:1];
_ac_name_pos.font = [UIFont systemFontOfSize:22];
_ac_name_pos.backgroundColor = [UIColor clearColor];
[(UMPLayoutView*)ac_name_line_1 addLayoutSubView:_ac_name_pos];
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
