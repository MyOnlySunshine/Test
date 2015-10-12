#import "lstCustomerListController.h"
@implementation lstCustomerListController
@synthesize m_cells_image,m_cells_label;
@synthesize name=_name;
@synthesize email=_email;
- (void)loadView
{
[super loadView];
}
- (void)viewDidLoad
{
[super viewDidLoad];

    
    listView = [[UMPListView alloc] initWithFrame:CGRectMake(0, 0, 320, 460-44) style:UITableViewStylePlain];
    [listView setDelegate:self];
    [listView setDataSource:self];
    [listView setRefreshDelegate:self];
    
    listView.topLoad = YES;//上拉刷新
    listView.bottomLoad = YES;//下拉刷新
    self.lineStyle = UMPBaseCellStyleDouble;//两行
    
    
    [self.view addSubview:listView];
    //初始化数据
    data = [[NSMutableArray alloc] initWithObjects:
            
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:1],@"type",
             @"NO.7987979798789",@"title",
             [NSNumber numberWithInt:12],@"titleFont",
             @"用友科技股份有限公司",@"name",
             [NSNumber numberWithInt:16],@"nameFont", nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:2],@"type",
             @"叶诗文",@"title",
             [NSNumber numberWithInt:16],@"titleFont",
             @"用友软件股份有限公司",@"name",
             [NSNumber numberWithInt:12],@"nameFont", nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:3],@"type",
             @"中铁局年终采购",@"title",
             [NSNumber numberWithInt:12],@"titleFont",
             @"成功率10%",@"name",
             [NSNumber numberWithInt:16],@"nameFont",
             @"类型",@"right",
             [NSNumber numberWithInt:12],@"rightFont",
             @"成功",@"last",
             [NSNumber numberWithInt:12],@"lastFont",nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:4],@"type",
             @"NO.7987979798789",@"title",
             [NSNumber numberWithInt:12],@"titleFont",
             @"百度科技有限公司",@"name",
             [NSNumber numberWithInt:16],@"nameFont",
             @"$67868687",@"right",
             [NSNumber numberWithInt:12],@"rightFont",
             @"2013-03-28",@"last",
             [NSNumber numberWithInt:12],@"lastFont",nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:5],@"type",
             @"摩托罗拉手机",@"title",
             [NSNumber numberWithInt:16],@"titleFont",
             @"NO.78978979878",@"name",
             [NSNumber numberWithInt:12],@"nameFont",
             @"GLASYEG 111",@"last",
             [NSNumber numberWithInt:12],@"lastFont",
             nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:6],@"type",
             @"勘探院10周年几年活动礼品",@"title",
             [NSNumber numberWithInt:16],@"titleFont",
             @"线索类型",@"name",
             [NSNumber numberWithInt:12],@"nameFont", nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:7],@"type",
             @"拜访总裁班章总",@"title",
             [NSNumber numberWithInt:12],@"titleFont",
             @"开始时间:2013-13-13",@"name",
             [NSNumber numberWithInt:16],@"nameFont",
             @"开始",@"right",
             [NSNumber numberWithInt:12],@"rightFont",
             @"刘德全",@"last",
             [NSNumber numberWithInt:12],@"lastFont",nil],
            
            [NSDictionary dictionaryWithObjectsAndKeys:
             [NSNumber numberWithInt:8],@"type",
             @"知识主题",@"title",
             [NSNumber numberWithInt:16],@"titleFont",
             @"知识类型",@"name",
             [NSNumber numberWithInt:12],@"nameFont",
             @"创建人",@"middle",
             [NSNumber numberWithInt:12],@"middleFont",
             @"2013-03-13",@"last",
             [NSNumber numberWithInt:12],@"lastFont",nil],nil];
//m_cells_image = [[NSMutableArray alloc]initWithCapacity:1];
//m_cells_label = [[NSMutableArray alloc]initWithCapacity:1];
}
- (void)viewDidUnload
{
[super viewDidUnload];
}
- (UITableViewCell*)tableView:(UITableView*)tableView cellForRowAtIndexPath:(NSIndexPath*)indexPath
{
    IndexPath = indexPath;
    
    static NSString *CellIdentifier = @"Cell";
    UMPRootCell *cell = (UMPRootCell *)[tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if (cell == nil) {
        cell = [[[ UMPRootCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier] autorelease];
        
        NSLog(@"绘制----第%d个",indexPath.row);
        
        cell.accessoryType = UITableViewCellAccessoryDisclosureIndicator;
    }
    
    
    cell.dictionary  = [data objectAtIndex:indexPath.row];
    
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
return [data count];
}
@end
