package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.domain.entities.Status;
import com.etiya.customerservice.repository.StatusRepository;
import com.etiya.customerservice.service.abstracts.StatusService;
import com.etiya.customerservice.service.mappings.StatusMapper;
import com.etiya.customerservice.service.requests.accountStatus.CreateStatusRequest;
import com.etiya.customerservice.service.responses.accountStatus.CreatedStatusResponse;
import com.etiya.customerservice.service.responses.accountStatus.GetListStatusResponse;
import com.etiya.customerservice.service.rules.StatusBusinessRules;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusBusinessRules statusBusinessRules;

    public StatusServiceImpl(StatusRepository statusRepository, StatusBusinessRules statusBusinessRules) {
        this.statusRepository = statusRepository;
        this.statusBusinessRules = statusBusinessRules;
    }

    @Override
    public CreatedStatusResponse add(CreateStatusRequest request) {
        statusBusinessRules.checkStatusExistsName(request.getName());
        Status status = StatusMapper.INSTANCE.statusFromCreateStatusRequest(request);
        Status result = statusRepository.save(status);
        CreatedStatusResponse response = StatusMapper.INSTANCE.createdStatusResponseFromStatus(result);
        return response;
    }

    @Override
    public List<GetListStatusResponse> getList() {
        List<Status> statuses = statusRepository.findAll();
        return StatusMapper.INSTANCE.getListStatusResponseFromStatus(statuses);
    }
}
