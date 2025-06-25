package com.cd.Arcadius.Pack;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/packs")
public class PackController {
    private final PackService packService;

    public PackController(PackService packService) {
        this.packService = packService;
    }
}
