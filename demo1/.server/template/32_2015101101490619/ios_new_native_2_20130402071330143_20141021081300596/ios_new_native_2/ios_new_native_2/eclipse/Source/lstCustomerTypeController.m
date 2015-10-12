#import "lstCustomerTypeController.h"
@implementation lstCustomerTypeController
@synthesize m_cells_image,m_cells_label;
@synthesize txtCustomerType=_txtCustomerType;
@synthesize cmdGo=_cmdGo;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];
UMPListView* table = [[UMPListView alloc] initWithFrame:CGRectMake(0,0,320,389)];
[table setDelegate:self];
[table setDataSource:self];
[self.view addSubview:table];
m_cells_image = [[NSMutableArray alloc]initWithCapacity:1];
m_cells_label = [[NSMutableArray alloc]initWithCapacity:1];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
- (UITableViewCell*)tableView:(UITableView*)tableView cellForRowAtIndexPath:(NSIndexPath*)indexPath
{
UITableViewCell *cell = [[UITableViewCell alloc] initWithStyle: UITableViewCellStyleDefault reuseIdentifier:@"table id"];
NSUInteger row = [indexPath row];
cell.imageView.image = [UIImage imageNamed:[m_cells_image objectAtIndex:row]];
cell.textLabel.text = [m_cells_label objectAtIndex:row];
return cell;
}
- (NSString*)tableView:(UITableView*)tableView titleForHeaderInSection:(NSInteger)section
{
return nil;
}
- (NSInteger)numberOfSectionsInTableView:(UITableView*)tableView
{
return 1;
}
- (NSInteger)tableView:(UITableView*)tableView numberOfRowsInSection:(NSInteger)section
{
return [m_cells_label count]|[m_cells_image count];
}
@end
