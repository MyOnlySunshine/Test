#import <UIKit/UIKit.h>
#import "UMPControls.h"
@interface lstCustomerTypeController: UMPListBaseController <UITableViewDelegate,UITableViewDataSource>
{
NSMutableArray* m_cells_image;
NSMutableArray* m_cells_label;
}
@property(nonatomic, strong) NSMutableArray* m_cells_image;
@property(nonatomic, strong) NSMutableArray* m_cells_label;
@property (retain) UMPLabel*txtCustomerType;
@property (retain) UMPButton*cmdGo;
@end
