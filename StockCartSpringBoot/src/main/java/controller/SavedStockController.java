package controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/saved_stocks")
@Api(value = "saved stocks controller")
@Component
public class SavedStockController {

}
