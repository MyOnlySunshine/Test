#import "CustomUI_lstCustomerListController.h"
@implementation CustomUI_lstCustomerListController
@synthesize name=_name;
@synthesize email=_email;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
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
