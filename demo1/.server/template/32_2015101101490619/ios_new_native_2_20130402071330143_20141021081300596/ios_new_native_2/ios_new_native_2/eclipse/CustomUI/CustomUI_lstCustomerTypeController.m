#import "CustomUI_lstCustomerTypeController.h"
@implementation CustomUI_lstCustomerTypeController
@synthesize txtCustomerType=_txtCustomerType;
@synthesize cmdGo=_cmdGo;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
    NSArray* ary = [NSArray arrayWithObjects:@"logo_link.png",@"logo_location.png",@"logo_mail.png",@"logo_men.png",@"logo_phone.png",@"logo_woman.png",nil];
    [m_cells_image addObjectsFromArray:ary];
        NSArray* ary1 = [NSArray arrayWithObjects:@"phone", @"email",@"commits",@"photo",@"day",@"week",nil];
    [m_cells_label addObjectsFromArray:ary1];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
- (UITableViewCell*)tableView:(UITableView*)tableView cellForRowAtIndexPath:(NSIndexPath*)indexPath
{
return [super tableView:tableView cellForRowAtIndexPath:indexPath];
}
- (NSString*)tableView:(UITableView*)tableView titleForHeaderInSection:(NSInteger)section
{
return [super tableView:tableView titleForHeaderInSection:section];
}
- (NSInteger)numberOfSectionsInTableView:(UITableView*)tableView
{
return [super numberOfSectionsInTableView:tableView];
}
- (NSInteger)tableView:(UITableView*)tableView numberOfRowsInSection:(NSInteger)section
{
return [super tableView:tableView numberOfRowsInSection:section];
}
@end
