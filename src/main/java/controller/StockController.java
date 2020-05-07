package controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.Stock;
import service.StockService;

// https://www.javaguides.net/2020/01/spring-boot-hibernate-oracle-crud-example.html
@RestController
@RequestMapping("/stock")
@Api(value = "Stocks" )
@Component
public class StockController {

	@Autowired
    private StockService stockService;
	
	
	@GetMapping("/")
	public String home() {
	     return "Home page";
	 }
	
	@GetMapping("/displayAllStocks")
	@ApiOperation(value = "Get all stocks.", notes = "Returns a list of all stocks.")
	public List<Stock> getAllStocks()
	{
		return stockService.getAllStocks();
	}
	
    @GetMapping("/getStock/{id}")
	   @ApiOperation(value = "Find stock detail by id.", notes = "Searches for stock using id.")
    public ResponseEntity < Stock > getStockById(@PathVariable(value = "id") Long stockId)
    throws ResourceNotFoundException {
        Stock stock = stockService.getStock(stockId)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + stockId));
        return ResponseEntity.ok().body(stock);
    }

    @PostMapping("/addStock")
    @ApiOperation(value = "Create new stock.", notes = "Requires stock details.")
    public Stock createStock(@Valid @RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    
    
    @PutMapping("/updateStock/{id}")
    public void updateStock(@PathVariable(value = "id") Long StockId,
        @Valid @RequestBody Stock stockDetails) throws ResourceNotFoundException {
        Stock stock = stockService.getStock(StockId)
            .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + StockId));

        stock.setCompanyName(stockDetails.getCompanyName());
        //stock.setCategory(stockDetails.getCategory());
        stock.setPrice(stockDetails.getPrice());
        stock.setQuantityBought(stockDetails.getQuantityBought());


        stockService.updateStock(stock);
       
    }

    
        
        @DeleteMapping("/deleteStock/{id}")
        public Map < String, Boolean > deleteStocks(@PathVariable(value = "id") Long StockId)
        throws ResourceNotFoundException {
            Stock stock = stockService.getStock(StockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found for this id :: " + StockId));

            stockService.deleteStocks(stock.getId());
            Map < String, Boolean > response = new HashMap < > ();
            response.put("deleted", Boolean.TRUE);
            return response;
    }

}
