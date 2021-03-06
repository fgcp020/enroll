package com.nercel.enroll.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nercel.enroll.core.service.BasicDataService;
import com.nercel.enroll.dao.impl.CertificatesTypeDao;
import com.nercel.enroll.dao.impl.CountryDao;
import com.nercel.enroll.dao.impl.NationDao;
import com.nercel.enroll.dao.impl.RelationalDao;
import com.nercel.enroll.dao.impl.SchoolDao;
import com.nercel.enroll.dao.impl.StreetSchoolDao;
import com.nercel.enroll.dao.impl.StudentInfoDao;
import com.nercel.enroll.domain.model.beans.CertificatesType;
import com.nercel.enroll.domain.model.beans.Country;
import com.nercel.enroll.domain.model.beans.Nation;
import com.nercel.enroll.domain.model.beans.Relational;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.beans.StreetSchool;
import com.nercel.enroll.domain.model.beans.StudentInfo;
/**
 * BasicDataService接口实现类
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@Service
public class BasicDataServiceImpl extends BaseService implements BasicDataService {
//	private static final Logger LOG = LoggerFactory.getLogger(BasicDataServiceImpl.class);

	@Autowired
	private NationDao nationDao;

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private CertificatesTypeDao certificatesTypeDao;

	@Autowired
	private RelationalDao relationalDao;

	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private StreetSchoolDao streetSchoolDao;

	@Autowired
	private StudentInfoDao studentInfoDao;


	@Override
	public List<Nation> queryAllNation() {
		return nationDao.queryAllNation();
	}

	@Override
	public List<Country> queryAllCountry() {
		return countryDao.queryAllCountry();
	}

	@Override
	public List<CertificatesType> queryAllCertificatesType() {
		return certificatesTypeDao.queryAllCertificatesType();
	}

	@Override
	public List<Relational> queryAllRelational() {
		return relationalDao.queryAllRelational();
	}

	@Override
	public List<School> queryAllSchool() {
		return schoolDao.queryAllSchool();
	}

	@Override
	public List<StreetSchool> queryAllStreetSchool() {
		return streetSchoolDao.queryAllStreetSchool();
	}

	@Override
	public List<StudentInfo> queryAllStudentInfo() {
		return studentInfoDao.queryAllStudentInfo();
	}

	@Override
	public List<StudentInfo> queryStudentInfo(String studentNumber) {
		return studentInfoDao.queryStudentInfo(studentNumber);
	}

	@Override
	public List<School> querySchoolByType(Integer schoolType) {
		return schoolDao.querySchoolByType(schoolType);
	}

	

}
