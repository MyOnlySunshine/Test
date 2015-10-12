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
    NSArray* ary = [NSArray arrayWithObjects:@"c1.jpg", @"c2.jpg",@"c3.jpg",@"c4.jpg",@"c5.jpg",@"c6.jpg",nil];
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

- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    CGFloat height = 0.0;
    
    switch (self.lineStyle) {
        case UMPBaseCellStyleSingle:
            
            height = 44.f;
            
            break;
        case UMPBaseCellStyleDouble:
            
            height = 70.f;
            
            break;
            
            
        default:
            break;
    }
    
    return height;
}
@end
