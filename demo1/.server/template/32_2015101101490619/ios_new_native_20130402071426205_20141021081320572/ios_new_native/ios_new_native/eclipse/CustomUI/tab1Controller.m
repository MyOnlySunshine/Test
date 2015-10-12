#import "tab1Controller.h"
#import "CustomUI_acController.h"
@implementation tab1Controller
@synthesize currentContainer=_currentContainer;
@synthesize main_title=_main_title;
@synthesize main_next=_main_next;
@synthesize main_customer=_main_customer;
@synthesize main_product=_main_product;
@synthesize main_order=_main_order;
@synthesize main_action=_main_action;
@synthesize main_contract=_main_contract;
@synthesize main_work=_main_work;
@synthesize main_lines=_main_lines;
@synthesize main_chance=_main_chance;
@synthesize main_knowdge=_main_knowdge;
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
[_currentContainer initController:@"tab1Controller"];
self.view=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat tab1width=0;
CGFloat tab1height=0;
tab1width = [[UIScreen mainScreen] applicationFrame].size.width;
tab1height = [[UIScreen mainScreen] applicationFrame].size.height-49;
self.view.frame = CGRectMake(0, 0, tab1width,tab1height);
UMPLayoutView*main=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat mainwidth;
CGFloat mainheight;
mainwidth = self.view.frame.size.width;
mainheight = self.view.frame.size.height;
main.frame = CGRectMake(0,0,mainwidth,mainheight);
main.weightUMPView = 1;
main.paddingLeftUMP = 0;
main.paddingTopUMP = 0;
main.backgroundColor = [UIColor clearColor];
[self.view addLayoutSubView:main];
UMPLayoutView*main_head=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat main_headwidth;
CGFloat main_headheight;
main_headwidth = main.frame.size.width;
main_headheight = 42;
main_head.frame = CGRectMake(0,0,main_headwidth,main_headheight);
main_head.weightUMPView = 0;
main_head.paddingLeftUMP = 0;
main_head.paddingTopUMP = 0;
[main_head setBackgroundImageWithPathForUMP:@"background"];
[main addLayoutSubView:main_head];
UMPLayoutView*main_content=[[UMPLayoutView alloc] initWithLayoutType:Layout_vbox];
CGFloat main_contentwidth;
CGFloat main_contentheight;
main_contentwidth = main.frame.size.width;
main_contentheight = 0;
main_content.frame = CGRectMake(0,0,main_contentwidth,main_contentheight);
main_content.weightUMPView = 1;
main_content.paddingLeftUMP = 0;
main_content.paddingTopUMP = 0;
main_content.backgroundColor = [UIColor clearColor];
[main addLayoutSubView:main_content];
UMPLabel*main_title= [[UMPLabel alloc] initDefault];
CGFloat main_titlewidth;
CGFloat main_titleheight;
main_titlewidth = 0;
main_titleheight = main_head.frame.size.height;
main_title.frame = CGRectMake(0,0,main_titlewidth,main_titleheight);
main_title.weightUMPView = 1;
main_title.paddingLeftUMP = 0;
main_title.paddingTopUMP = 0;
main_title.title = @"客户关系管理";
main_title.textAlignment = UITextAlignmentCenter;
main_title.textColor = [UIColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1];
main_title.font = [UIFont systemFontOfSize:22];
main_title.backgroundColor = [UIColor clearColor];
[main_head addLayoutSubView:main_title];
UMPButton*main_next= [[UMPButton alloc] initDefault];
CGFloat main_nextwidth;
CGFloat main_nextheight;
main_nextwidth = 60;
main_nextheight = main_head.frame.size.height;
main_next.frame = CGRectMake(0,0,main_nextwidth,main_nextheight);
main_next.weightUMPView = 0;
main_next.paddingLeftUMP = 0;
main_next.paddingTopUMP = 0;
[main_next setBackgroundImgFromPath:@"1" forState:UMP_Controls_State_Normal];
[main_next addTarget:self action:@selector(nextPage) forControlEvents:UIControlEventTouchUpInside];
[main_head addLayoutSubView:main_next];
UMPLayoutView*row1=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat row1width;
CGFloat row1height;
row1width = main_content.frame.size.width;
row1height = 0;
row1.frame = CGRectMake(0,0,row1width,row1height);
row1.weightUMPView = 1;
row1.paddingLeftUMP = 0;
row1.paddingTopUMP = 0;
row1.backgroundColor = [UIColor clearColor];
[main_content addLayoutSubView:row1];
UMPLayoutView*row2=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat row2width;
CGFloat row2height;
row2width = main_content.frame.size.width;
row2height = 0;
row2.frame = CGRectMake(0,0,row2width,row2height);
row2.weightUMPView = 1;
row2.paddingLeftUMP = 0;
row2.paddingTopUMP = 0;
row2.backgroundColor = [UIColor clearColor];
[main_content addLayoutSubView:row2];
UMPLayoutView*row3=[[UMPLayoutView alloc] initWithLayoutType:Layout_hbox];
CGFloat row3width;
CGFloat row3height;
row3width = main_content.frame.size.width;
row3height = 0;
row3.frame = CGRectMake(0,0,row3width,row3height);
row3.weightUMPView = 1;
row3.paddingLeftUMP = 0;
row3.paddingTopUMP = 0;
row3.backgroundColor = [UIColor clearColor];
[main_content addLayoutSubView:row3];
UMPButton*main_customer= [[UMPButton alloc] initDefault];
CGFloat main_customerwidth;
CGFloat main_customerheight;
main_customerwidth = 0;
main_customerheight = row1.frame.size.height;
main_customer.frame = CGRectMake(0,0,main_customerwidth,main_customerheight);
main_customer.weightUMPView = 1;
main_customer.paddingLeftUMP = 0;
main_customer.paddingTopUMP = 0;
[main_customer setBackgroundImgFromPath:@"index-客户-初始.png" forState:UMP_Controls_State_Normal];
[row1 addLayoutSubView:main_customer];
UMPButton*main_product= [[UMPButton alloc] initDefault];
CGFloat main_productwidth;
CGFloat main_productheight;
main_productwidth = 0;
main_productheight = row1.frame.size.height;
main_product.frame = CGRectMake(0,0,main_productwidth,main_productheight);
main_product.weightUMPView = 1;
main_product.paddingLeftUMP = 0;
main_product.paddingTopUMP = 0;
[main_product setBackgroundImgFromPath:@"index-产品-常态.png" forState:UMP_Controls_State_Normal];
[row1 addLayoutSubView:main_product];
UMPButton*main_order= [[UMPButton alloc] initDefault];
CGFloat main_orderwidth;
CGFloat main_orderheight;
main_orderwidth = 0;
main_orderheight = row1.frame.size.height;
main_order.frame = CGRectMake(0,0,main_orderwidth,main_orderheight);
main_order.weightUMPView = 1;
main_order.paddingLeftUMP = 0;
main_order.paddingTopUMP = 0;
[main_order setBackgroundImgFromPath:@"index-订单-初始.png" forState:UMP_Controls_State_Normal];
[row1 addLayoutSubView:main_order];
UMPButton*main_action= [[UMPButton alloc] initDefault];
CGFloat main_actionwidth;
CGFloat main_actionheight;
main_actionwidth = 0;
main_actionheight = row2.frame.size.height;
main_action.frame = CGRectMake(0,0,main_actionwidth,main_actionheight);
main_action.weightUMPView = 1;
main_action.paddingLeftUMP = 0;
main_action.paddingTopUMP = 0;
[main_action setBackgroundImgFromPath:@"index-行动-初始.png" forState:UMP_Controls_State_Normal];
[row2 addLayoutSubView:main_action];
UMPButton*main_contract= [[UMPButton alloc] initDefault];
CGFloat main_contractwidth;
CGFloat main_contractheight;
main_contractwidth = 0;
main_contractheight = row2.frame.size.height;
main_contract.frame = CGRectMake(0,0,main_contractwidth,main_contractheight);
main_contract.weightUMPView = 1;
main_contract.paddingLeftUMP = 0;
main_contract.paddingTopUMP = 0;
[main_contract setBackgroundImgFromPath:@"index-联系人-常态.png" forState:UMP_Controls_State_Normal];
[row2 addLayoutSubView:main_contract];
UMPButton*main_work= [[UMPButton alloc] initDefault];
CGFloat main_workwidth;
CGFloat main_workheight;
main_workwidth = 0;
main_workheight = row2.frame.size.height;
main_work.frame = CGRectMake(0,0,main_workwidth,main_workheight);
main_work.weightUMPView = 1;
main_work.paddingLeftUMP = 0;
main_work.paddingTopUMP = 0;
[main_work setBackgroundImgFromPath:@"index-日程-初始.png" forState:UMP_Controls_State_Normal];
[row2 addLayoutSubView:main_work];
UMPButton*main_lines= [[UMPButton alloc] initDefault];
CGFloat main_lineswidth;
CGFloat main_linesheight;
main_lineswidth = 0;
main_linesheight = row3.frame.size.height;
main_lines.frame = CGRectMake(0,0,main_lineswidth,main_linesheight);
main_lines.weightUMPView = 1;
main_lines.paddingLeftUMP = 0;
main_lines.paddingTopUMP = 0;
[main_lines setBackgroundImgFromPath:@"index-线索-初始.png" forState:UMP_Controls_State_Normal];
[row3 addLayoutSubView:main_lines];
UMPButton*main_chance= [[UMPButton alloc] initDefault];
CGFloat main_chancewidth;
CGFloat main_chanceheight;
main_chancewidth = 0;
main_chanceheight = row3.frame.size.height;
main_chance.frame = CGRectMake(0,0,main_chancewidth,main_chanceheight);
main_chance.weightUMPView = 1;
main_chance.paddingLeftUMP = 0;
main_chance.paddingTopUMP = 0;
[main_chance setBackgroundImgFromPath:@"index-销售机会-初始.png" forState:UMP_Controls_State_Normal];
[row3 addLayoutSubView:main_chance];
UMPButton*main_knowdge= [[UMPButton alloc] initDefault];
CGFloat main_knowdgewidth;
CGFloat main_knowdgeheight;
main_knowdgewidth = 0;
main_knowdgeheight = row3.frame.size.height;
main_knowdge.frame = CGRectMake(0,0,main_knowdgewidth,main_knowdgeheight);
main_knowdge.weightUMPView = 1;
main_knowdge.paddingLeftUMP = 0;
main_knowdge.paddingTopUMP = 0;
[main_knowdge setBackgroundImgFromPath:@"index-知识库-常态.png" forState:UMP_Controls_State_Normal];
[row3 addLayoutSubView:main_knowdge];
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
