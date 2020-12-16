package edu.javavt18.controllers;

import edu.javavt18.model.MarketSupplier;
import edu.javavt18.model.MarketProduct;
import edu.javavt18.service.MarketSupplierService;
import edu.javavt18.service.MarketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class HibernateController {

    private static final String INSTRUMENT = "hibernate";
    private static final String TITLE = "Hibernate";

    @Autowired
    @Qualifier("marketSupplierHibernateService")
    private MarketSupplierService marketSupplierService;
    @Autowired
    @Qualifier("marketProductHibernateService")
    private MarketProductService marketProductService;

    @RequestMapping(value = "/"+INSTRUMENT+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("instrument", INSTRUMENT);

        List<MarketSupplier> listMarketSupplier = marketSupplierService.list();
        List<MarketProduct> listMarketProduct = marketProductService.list();

        model.addAttribute("listMarketProduct",listMarketProduct);
        model.addAttribute("listMarketSupplier",listMarketSupplier);
        return "content";
    }

    //CRUD operations with MarketSupplier entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newSupplier", method = RequestMethod.GET)
    public String addBrand(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");

        MarketSupplier marketSupplier = new MarketSupplier();
        model.addAttribute("marketSupplier", marketSupplier);

        return "supplierForm";
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/newSupplier" }, method = RequestMethod.POST)
    public String saveBrand(MarketSupplier marketSupplier) {

        marketSupplierService.saveOrUpdate(marketSupplier);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-supplier/{idSupplier}" }, method = RequestMethod.GET)
    public String deleteBrand(@PathVariable int idSupplier) {
        marketSupplierService.delete(idSupplier);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-supplier/{idSupplier}" }, method = RequestMethod.GET)
    public String editBrand(@PathVariable int idSupplier, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        MarketSupplier marketSupplier = marketSupplierService.get(idSupplier);
        model.addAttribute("marketSupplier", marketSupplier);
        model.addAttribute("edit", true);
        return "supplierForm";
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-supplier/{idSupplier}" }, method = RequestMethod.POST)
    public String updateBrand(MarketSupplier carBrand) {
        marketSupplierService.saveOrUpdate(carBrand);
        return "redirect:/"+INSTRUMENT;
    }

    //CRUD operations with MarketProduct entity
    @RequestMapping(value = "/"+INSTRUMENT+"/newProduct", method = RequestMethod.GET)
    public String addModel(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");

        List<MarketSupplier> listMarketSupplier = marketSupplierService.list();
        System.out.println(listMarketSupplier);
        MarketProduct marketProduct = new MarketProduct();
        model.addAttribute("listMarketSupplier", listMarketSupplier);
        model.addAttribute("marketProduct", marketProduct);

        return "productForm";
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/newProduct" }, method = RequestMethod.POST)
    public String saveModel(MarketProduct marketProduct) {

        int idBrand = marketProduct.getIdSupplier();
        marketProduct.setMarketSupplier(marketSupplierService.get(idBrand));
        marketProductService.saveOrUpdate(marketProduct);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-model/{idProduct}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int idProduct) {
        marketProductService.delete(idProduct);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-model/{idProduct}" }, method = RequestMethod.GET)
    public String editModel(@PathVariable int idProduct, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        MarketProduct marketProduct = marketProductService.get(idProduct);
        List<MarketSupplier> listMarketSupplier = marketSupplierService.list();

        model.addAttribute("marketProduct", marketProduct);
        model.addAttribute("listMarketSupplier", listMarketSupplier);

        return "productForm";
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-model/{idProduct}" }, method = RequestMethod.POST)
    public String updateModel(MarketProduct marketProduct) {

        int idProduct = marketProduct.getIdSupplier();
        marketProduct.setMarketSupplier(marketSupplierService.get(idProduct));

        marketProductService.saveOrUpdate(marketProduct);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {"/"+INSTRUMENT+"/pdfReport", "/"+INSTRUMENT+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<MarketSupplier> listMarketSupplier = marketSupplierService.list();
        List<MarketProduct> listMarketProduct = marketProductService.list();
        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("carBrands", listMarketSupplier);
        modelAndView.addObject("marketProducts", listMarketProduct);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}