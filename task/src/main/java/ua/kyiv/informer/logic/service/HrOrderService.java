package ua.kyiv.informer.logic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kyiv.informer.logic.repository.HrOrderRepository;
import ua.kyiv.informer.ui.hr.order.HrOrderModel;

@Service
public class HrOrderService {

	@Autowired
	private HrOrderRepository hrOrderRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public HrOrderService() {
		super();
	}
	
	public List<HrOrderModel> getHrOrderList() {
		return hrOrderRepository.findAll().stream().parallel()
				.map(HrOrder -> modelMapper.map(HrOrder, HrOrderModel.class))
				.collect(Collectors.toList());
	}
}
