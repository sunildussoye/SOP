package com.salesorderprocessing.bootstrap;

import com.salesorderprocessing.domain.*;
import com.salesorderprocessing.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataSetup {

    private final CustomerService customerService;
    private final OrderHeaderService orderHeaderService;
    private final ProductService productService;
    private final InvoiceService invoiceService;
    private final ReturnService returnService;
    private final DeliveryService deliveryService;

    @PostConstruct
    public void loadData() {
        loadProduct();
        loadCustomer();
        loadOrder();
    }


    private void loadProduct() {
        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setColour("Blue");
        productAttribute.setSize(9.5);
        productAttribute.setSex("Woman");

        Product product = new Product();
        product.setProductCategory("Running");
        product.setProductDescription("Nike Running Shoes");
        product.setProductPrice(new BigDecimal(67.99));
        product.setProductAvailable(true);
        product.setProductAttribute(productAttribute);
        productService.saveOrUpdate(product);

        ProductAttribute productAttribute1 = new ProductAttribute();
        productAttribute1.setColour("White");
        productAttribute1.setSize(10.5);
        productAttribute1.setSex("Man");
        productAttribute1.setStripes("3 White Stripes");

        Product product1 = new Product();
        product1.setProductCategory("Running");
        product1.setProductDescription("Addidas Running Shoes");
        product1.setProductPrice(new BigDecimal(89.99));
        product1.setProductAvailable(true);
        product1.setProductAttribute(productAttribute1);
        productService.saveOrUpdate(product1);

        ProductAttribute productAttribute2 = new ProductAttribute();
        productAttribute2.setColour("Pink and White");
        productAttribute2.setSize(4.5);
        productAttribute2.setSex("Girl");

        Product product2 = new Product();
        product2.setProductCategory("Running");
        product2.setProductDescription("Nike Running Shoes");
        product2.setProductPrice(new BigDecimal(34.77));
        product2.setProductAvailable(true);
        product2.setProductAttribute(productAttribute2);
        productService.saveOrUpdate(product2);

        ProductAttribute productAttribute3 = new ProductAttribute();
        productAttribute3.setColour("Black");
        productAttribute3.setSize(9.5);
        productAttribute3.setSex("Man");

        Product product3 = new Product();
        product3.setProductCategory("Running");
        product3.setProductDescription("Addidas Samba Shoes");
        product3.setProductPrice(new BigDecimal(99));
        product3.setProductAvailable(true);
        product3.setProductAttribute(productAttribute3);
        productService.saveOrUpdate(product3);

        ProductAttribute productAttribute4 = new ProductAttribute();
        productAttribute4.setColour("White");
        productAttribute4.setSex("Unisex");

        Product product4 = new Product();
        product4.setProductCategory("Umbrella");
        product4.setProductDescription("Golf Umbrella");
        product4.setProductPrice(new BigDecimal(119.78));
        product4.setProductAvailable(true);
        product4.setProductAttribute(productAttribute4);
        productService.saveOrUpdate(product4);

        ProductAttribute productAttribute5 = new ProductAttribute();
        productAttribute5.setColour("Red");
        productAttribute5.setSize(9.5);
        productAttribute5.setSex("Man");

        Product product5 = new Product();
        product5.setProductCategory("Scarf");
        product5.setProductDescription("Liverpool Scarf");
        product5.setProductPrice(new BigDecimal(9.99));
        product5.setProductAvailable(false);
        product5.setProductAttribute(productAttribute5);
        productService.saveOrUpdate(product5);

        ProductAttribute productAttribute6 = new ProductAttribute();
        productAttribute6.setColour("Purple");
        productAttribute6.setSize(9.5);
        productAttribute6.setSex("Woman");

        Product product6 = new Product();
        product6.setProductCategory("Jogging");
        product6.setProductDescription("Nike Tracksuit");
        product6.setProductPrice(new BigDecimal(88));
        product6.setProductAttribute(productAttribute6);
        product6.setProductAvailable(true);
        productService.saveOrUpdate(product6);

        ProductAttribute productAttribute7 = new ProductAttribute();
        productAttribute7.setColour("White");
        productAttribute7.setSex("Unisex");

        Product product7 = new Product();
        product7.setProductCategory("Racket");
        product7.setProductDescription("Squash Racket");
        product7.setProductPrice(new BigDecimal(67.99));
        product7.setProductAvailable(true);
        product7.setProductAttribute(productAttribute7);
        productService.saveOrUpdate(product7);

        ProductAttribute productAttribute8 = new ProductAttribute();
        productAttribute8.setColour("White");
        productAttribute8.setSex("Unisex");

        Product product8 = new Product();
        product8.setProductCategory("Badminton");
        product8.setProductDescription("Badminton Racket");
        product8.setProductPrice(new BigDecimal(45.99));
        product8.setProductAvailable(true);
        product8.setProductAttribute(productAttribute8);
        productService.saveOrUpdate(product8);

        ProductAttribute productAttribute9 = new ProductAttribute();
        productAttribute9.setColour("Red");
        productAttribute9.setSex("Unisex");

        Product product9 = new Product();
        product9.setProductCategory("Tabletennis");
        product9.setProductDescription("Racket");
        product9.setProductPrice(new BigDecimal(67.99));
        product9.setProductAvailable(true);
        product9.setProductAttribute(productAttribute9);
        productService.saveOrUpdate(product9);

        ProductAttribute productAttribute10 = new ProductAttribute();
        productAttribute10.setColour("Blue");
        productAttribute10.setSize(9.5);
        productAttribute10.setSex("Woman");

        Product product10 = new Product();
        product10.setProductCategory("Swimming");
        product10.setProductDescription("Nike Swiming trunks");
        product10.setProductPrice(new BigDecimal(88));
        product10.setProductAvailable(true);
        product10.setProductAttribute(productAttribute10);
        productService.saveOrUpdate(product10);
    }

    private void loadCustomer() {
        Address address = new Address();
        address.setAddressLine1("Wisteria House");
        address.setAddressLine2("South End");
        address.setAddressLine2("Seaton Ross");
        address.setCountry("North YorkShire");
        address.setPostCode("YO424LT");
        address.setCountry("UK");

        Address deliveryaddress = new Address();
        deliveryaddress.setAddressLine1("Wisteria Delivery House");
        deliveryaddress.setAddressLine2("Delivery South End");
        deliveryaddress.setAddressLine2("Delivery Seaton Ross");
        deliveryaddress.setCountry("Delivery North YorkShire");
        deliveryaddress.setPostCode("Delivery YO424LT");
        deliveryaddress.setCountry("DeliveryUK");

        Customer customer = new Customer();
        customer.setCustReference("001");
        customer.setFirstName("Sunil");
        customer.setLastName("Dussoye");
        customer.setEmail("sun@gmail.com");
        customer.setCustomerAddress(address);
        customer.setDeliveryAddress(deliveryaddress);
        customer.setPhoneNumber("00447906789");
        customer.setAddressType("C");
        customerService.saveOrUpdate(customer);

        Address address1 = new Address();
        address1.setAddressLine1("65 Idsworth Rd");
        address1.setAddressLine2("South Yorkshire");
        address1.setAddressLine2("Sheffield");
        address1.setCountry("South YorkShire");
        address1.setPostCode("S5 6UN");
        address1.setCountry("UK");

        Customer customer1 = new Customer();
        customer1.setCustReference("002");
        customer1.setFirstName("Pedro");
        customer1.setLastName("Rodrigues");
        customer1.setEmail("pedro@gmail.com");
        customer1.setCustomerAddress(address1);
        customer1.setPhoneNumber("00352632767");
        customer1.setAddressType("I");
        customerService.saveOrUpdate(customer1);

        Address address2 = new Address();
        address2.setAddressLine1("Barnley House");
        address2.setAddressLine2("South End");
        address2.setAddressLine2("Acrit Ross");
        address2.setCountry("Manchester");
        address2.setPostCode("Man123");
        address2.setCountry("UK");

        Customer customer2 = new Customer();
        customer2.setCustReference("003");
        customer2.setFirstName("Gaeve");
        customer2.setLastName("Klopp");
        customer2.setEmail("klopp@gmail.com");
        customer2.setCustomerAddress(address2);
        customer2.setPhoneNumber("0161787888");
        customer2.setAddressType("C");

        customerService.saveOrUpdate(customer2);

        Address address3 = new Address();
        address3.setAddressLine1("Sir Hilary Blood");
        address3.setAddressLine2("dfffff");
        address3.setAddressLine2(" Rvvvvoss");
        address3.setCountry("NQuatre-Bornes");
        address3.setPostCode("Mu789");
        address3.setCountry("Mauritius");

        Customer customer3 = new Customer();
        customer3.setCustReference("004");
        customer3.setFirstName("Gaston");
        customer3.setLastName("Charpentier");
        customer3.setEmail("gaston@gmail.com");
        customer3.setCustomerAddress(address3);
        customer3.setPhoneNumber("002309090");
        customer3.setAddressType("C");
        customerService.saveOrUpdate(customer3);

        Address address4 = new Address();
        address4.setAddressLine1("Tandoori  House");
        address4.setAddressLine2("Balti End");
        address4.setAddressLine2("Chilli Ross");
        address4.setCountry("North India");
        address4.setPostCode("IND909");
        address4.setCountry("India");

        Customer customer4 = new Customer();
        customer4.setCustReference("005");
        customer4.setFirstName("Punjab");
        customer4.setLastName("Kalia");
        customer4.setEmail("pun@gmail.com");
        customer4.setCustomerAddress(address4);
        customer4.setPhoneNumber("00909000");
        customer4.setAddressType("D");
        customerService.saveOrUpdate(customer4);
    }

    private void loadOrder() {

        // Grab a handful of customers
        Customer customer = customerService.findByReference("001");
        Customer customer1 = customerService.getById(2);


        // current list of products
        Iterable<Product> products = productService.listAll();

        // create order
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer(customer);
        orderHeader.setOrderNum("A123");
        orderHeader.setOrderStatus(OrderStatus.ALLOCATED);
        orderHeader.setOrderDate(LocalDate.now());

        // Raise an  Invoice for this order
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setInvoiceReference(customer.getCustReference() + "/I001");

        // Raise a  delivery Note for this order
        Delivery delivery = new Delivery();
        delivery.setCustomer(customer);
        delivery.setDeliveryReference(customer.getCustReference() + "D001");
        delivery.addOrderToDelivery(orderHeader);

        products.forEach(product -> {
            // only attach Male products to customer 1
            if (product.getProductAttribute().getSex() == "Man") {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(2);
                orderHeader.addToOrderDetails(orderDetail);
                invoice.addorderlinesToInvoice(orderDetail);
                /* we deliver only 2 items out of the 3 ordered */
                if (product.getProductAvailable()) {
                    delivery.addDeliveredGoods(orderDetail);
                }
            }
        });

        orderHeaderService.saveOrUpdate(orderHeader);
        invoice.addOrderToInvoice(orderHeader);
        invoiceService.saveOrUpdate(invoice);
        deliveryService.saveOrUpdate(delivery);

        // Simulate a Return against this order
        Delivery goodsdelivery = deliveryService.findFirstByOrderHeader(orderHeader);
        //  System.out.println("goodsdelivery" + goodsdelivery.getDeliveryReference());
        Return goodsreturn = new Return();
        goodsreturn.setCustomer(customer);
        goodsreturn.setReturnReference(customer.getCustReference() + "R001");
        goodsreturn.setOrder(orderHeader);
        goodsreturn.addToReturn(goodsdelivery);
        returnService.saveOrUpdate(goodsreturn);


        /* should now be able to run via SQL or endpoints
        - order for custmer
        - deliveryNoteMatching
        etc
        */
    }
}
