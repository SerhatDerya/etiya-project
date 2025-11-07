package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.domain.entities.Status;
import com.etiya.customerservice.repository.StatusRepository;
import com.etiya.customerservice.service.abstracts.StatusService;
import com.etiya.customerservice.service.mappings.StatusMapper;
import com.etiya.customerservice.service.requests.accountStatus.CreateStatusRequest;
import com.etiya.customerservice.service.responses.accountStatus.CreatedStatusResponse;
import com.etiya.customerservice.service.responses.accountStatus.GetListStatusResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public CreatedStatusResponse add(CreateStatusRequest request) {
        Status status = StatusMapper.INSTANCE.statusFromCreateStatusRequest(request);
        Status result = statusRepository.save(status);
        CreatedStatusResponse response = StatusMapper.INSTANCE.createdStatusResponseFromStatus(result);
        return response;

//        Status status = new Status();
//        status.setName(request.getName());
//        Status result = statusRepository.save(status);
//        CreatedStatusResponse response = new CreatedStatusResponse();
//        response.setId(result.getId());
//        return response;
    }

    @Override
    public List<GetListStatusResponse> getList() {
        List<Status> statuses = statusRepository.findAll();
        return StatusMapper.INSTANCE.getListStatusResponseFromStatus(statuses);
    }
}
