#import <UIKit/UIKit.h>
#import "UMPControls.h"
@interface lstCustomerListController: UMPListBaseController <UITableViewDelegate,UITableViewDataSource>
{
NSMutableArray* m_cells_image;
NSMutableArray* m_cells_label;
    
    NSMutableArray * data;
    NSIndexPath * IndexPath;
}
@property(nonatomic, strong) NSMutableArray* m_cells_image;
@property(nonatomic, strong) NSMutableArray* m_cells_label;
@property (retain) UMPLabel*name;
@property (retain) UMPLabel*email;
@end
