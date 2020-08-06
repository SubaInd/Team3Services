package com.qthonservices.practisemcqservices.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.qthonservices.practisemcqservices.models.PractiseMcq;


@EnableScan
public interface PractiseMcqRepository extends CrudRepository<PractiseMcq, String> {


}
