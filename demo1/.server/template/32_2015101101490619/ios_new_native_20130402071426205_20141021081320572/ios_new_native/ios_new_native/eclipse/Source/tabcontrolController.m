#import "tabcontrolController.h"
#import "CustomUI_tab1Controller.h"
#import "CustomUI_tab2Controller.h"
#import "CustomUI_tab3Controller.h"
@implementation tabcontrolController
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
NSMutableArray* tabPageControllers_array = [NSMutableArray arrayWithCapacity:1];
CustomUI_tab1Controller*tab1=[[CustomUI_tab1Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*tab1ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"短信" image:nil tag:0];
tab1ItemBar.customUnselectedImage = [UIImage imageNamed:@"TabBarApproval.png"];
tab1ItemBar.customSelectedImage = [UIImage imageNamed:@"TabBarApproval_select"];
tab1.tabBarItem =tab1ItemBar;
[tabPageControllers_array addObject:tab1];
CustomUI_tab2Controller*tab2=[[CustomUI_tab2Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*tab2ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"邮件" image:nil tag:0];
tab2ItemBar.customUnselectedImage = [UIImage imageNamed:@"TabBarMsg.png"];
tab2ItemBar.customSelectedImage = [UIImage imageNamed:@"TabBarMsg_select"];
tab2.tabBarItem =tab2ItemBar;
[tabPageControllers_array addObject:tab2];
CustomUI_tab3Controller*tab3=[[CustomUI_tab3Controller alloc] initWithNibName:nil bundle:nil];
UMPTabBarItem*tab3ItemBar = [[UMPTabBarItem alloc] initWithTitle:@"统计" image:nil tag:0];
tab3ItemBar.customUnselectedImage = [UIImage imageNamed:@"TabBarReport.png"];
tab3ItemBar.customSelectedImage = [UIImage imageNamed:@"TabBarReport_select"];
tab3.tabBarItem =tab3ItemBar;
[tabPageControllers_array addObject:tab3];
 [self setViewControllers:tabPageControllers_array];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
@end
