package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioEntity;
import byfayzullayev.jaluzi.model.receive.portfolio.PortfolioReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.PortfolioRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService implements BaseService {
    private final PortfolioRepository portfolioRepository;
    private final FileService fileService;


    @Autowired
    public PortfolioService(PortfolioRepository portfolioRepository, FileService fileService) {
        this.portfolioRepository = portfolioRepository;
        this.fileService = fileService;
    }

    public ApiResponse addPortfolio(
            PortfolioReceiveModel portfolioReceiveModel
    ) {
        String imageUrl = fileService.saveFile(portfolioReceiveModel.getBase64(),
                portfolioReceiveModel.getContentType());
        if (imageUrl == null)
            return ERROR_FILE_CREATE;

        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setName(portfolioReceiveModel.getName());
        portfolioEntity.setImageUrl(imageUrl);
        portfolioRepository.save(portfolioEntity);

        return SUCCESS_V2;
    }


    public ApiResponse updatePortfolio(long id, PortfolioEntity portfolioEntity) {
        Optional<PortfolioEntity> optionalPortfolioEntity = portfolioRepository.findById(id);
        if (optionalPortfolioEntity.isPresent()) {
            PortfolioEntity updateId = optionalPortfolioEntity.get();
            Optional<PortfolioEntity> updatePortfolio = portfolioRepository.findByName(portfolioEntity.getName());

            if (updatePortfolio.isPresent())
                return USER_EXIST;

            updateId.setName(portfolioEntity.getName());
            portfolioRepository.save(updateId);
        }
        return SUCCESS_V2;
    }

    public ApiResponse getPortfolioList() {
        SUCCESS.setData(portfolioRepository.findAll());
        return SUCCESS;
    }

    public ApiResponse deletePortfolio(long id) {
        Optional<PortfolioEntity> optionalPortfolioEntity = portfolioRepository.findById(id);
        if (optionalPortfolioEntity.isPresent()) {
            portfolioRepository.deleteById(id);

            return SUCCESS_V2;
        }
        return ERROR_DELETE;
    }
}