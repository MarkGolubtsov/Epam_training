package action.chose_product;

import action.ActionWithForward;
import exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionCreateChoseProduct extends ActionWithForward {
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException {
           Forward forward = new Forward("/product/list.html");
//        String id_product = request.getParameter("productId");
//        User user=getAuthorizedUser();
//        int id_prod=Integer.valueOf(id_product);
//        ChoseProduct choseProduct = new ChoseProduct();
//        ProductService productService = factory.getService(ProductService.class);
//        Product  product =productService.readById(id_prod);
//        choseProduct.setProduct(product);
//        choseProduct.setUser(user);
//        ChoseProductService choseProductService = factory.getService(ChoseProductService.class);
//        List<ChoseProduct> choseProductsAll =choseProductService.findByUserId(user.getId());
//        boolean flagInc = false;
//        for (ChoseProduct c:
//             choseProductsAll) {
//            if (c.getProduct().getId() == choseProduct.getProduct().getId()) {
//                int count =c.getCount()+1;
//                c.setCount(count);
//                choseProductService.update(c);
//                flagInc=true;
//            }
//        }
//        if (!flagInc) {
//            choseProduct.setCount(1);
//            choseProductService.save(choseProduct);
//        }
        return forward;
    }
}
