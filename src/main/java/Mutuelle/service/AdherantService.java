package Mutuelle.service;


import Mutuelle.exception.BadRequestException;
import Mutuelle.model.Adherent;
import Mutuelle.model.Adherent;
import Mutuelle.model.User;
import Mutuelle.payload.PagedResponse;

import Mutuelle.security.UserPrincipal;
import Mutuelle.util.AppConstants;
import Mutuelle.util.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;


@Service
public class AdherantService {


}
