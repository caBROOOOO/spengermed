
INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_deceaseddatetime`, `p_deceasedboolean`, `p_gender`) VALUES ('1',1, '2000-01-01', '2010-01-01', 1, 'male');

INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`,`p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('2', 1,'2000-01-01','unknown', 1);

INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`,`p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('3', 0, '2001-04-05','male', 0);

INSERT INTO `spengermed`.`p_patient` (`id`, `p_active`, `p_birthdate`,`p_gender`, `p_deceasedboolean`) VALUES ('4', 1, '2010-01-21','female', 1);

INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('5','Stöger', '2099-12-31', '2000-01-01', 'David Stöger', 'usual','1');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('11','Hergge', '2099-12-31', '2000-01-01', 'Gregor Hergge', 'usual','2');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('12','Gruber', '2099-12-31', '2000-01-01', 'Jan Gruber', 'usual','3');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`,`pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_p_id`) VALUES ('13','Huber', '2099-12-31', '2000-01-01', 'Katja Huber', 'usual','4');

INSERT INTO `spengermed`.`a_adress` (`id`, `a_city`, `a_country`,`a_district`, `pp_end`, `pp_start`, `a_postalcode`, `a_state`, `a_p_id`)VALUES ('6', 'Wien', 'AUT', '10', '2099-12-31 16:36:34.000000','2020-04-27 16:36:49.000000', '1100', 'BiH', '4');

INSERT INTO `spengermed`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('7', 1, '2003-02-01', 'female');

INSERT INTO `spengermed`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('8', 1, '2005-03-08', 'male');
INSERT INTO `spengermed`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('9', 1, '1972-05-19', 'unknown');

INSERT INTO `spengermed`.`pr_practitioner` (`id`, `pr_active`, `pr_birthdate`, `pr_gender`) VALUES ('10', 1, '1963-06-03', 'male');

INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`, `pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_pr_id`) VALUES ('hn1', 'Haider', '2099-12-31', '2000-01-01', 'Sarah Haider', 'usual', '9');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`, `pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_pr_id`) VALUES ('hn2', 'Haider', '2099-12-31', '2000-01-01', 'Sarah Haider', 'usual', '8');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`, `pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_pr_id`) VALUES ('hn3', 'Haider', '2099-12-31', '2000-01-01', 'Sarah Haider', 'usual', '7');
INSERT INTO `spengermed`.`hn_humanname` (`id`, `hn_family`, `pp_end`, `pp_start`, `hn_text`, `hn_use`, `hn_pr_id`) VALUES ('hn4', 'Haider', '2099-12-31', '2000-01-01', 'Sarah Haider', 'usual', '10');

INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `at_pr_id`) VALUES ('a11', '2021-01-13', 'data', '#', 'de', 14, 'hi', 'http:spengergasse.at', '8');


INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('P1', 12, '2020-02-01', '2050-01-04', '2020-12-01', 'unknown');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('I1', 'temp', '2055-12-31', '2019-12-31', 'blabla', 'HAllo', 'P1');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pr_id`) VALUES ('I2', 'temp', '2055-12-31', '2019-12-31', 'blabla', 'HAllo', '7');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_p_id`) VALUES ('I3', 'temp', '2055-12-31', '2019-12-31', 'blabla', 'HAllo', '1');

INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('P2', 12, '2018-03-02', '2040-10-14', '2020-08-10', 'stopped');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('I4', 'temp', '2021-12-31', '2010-10-21', 'bliblablub', 'Tschau', 'P2');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pr_id`) VALUES ('I5', 'temp', '2021-12-31', '2010-10-21', 'bliblablub', 'Tschau', '8');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_p_id`) VALUES ('I6', 'temp', '2021-12-31', '2010-10-21', 'bliblablub', 'Tschau', '2');

INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n1','additional','div');

INSERT INTO `spengermed`.`pro_procedure` (`id`, `pro_instantiatesuri`, `pro_performeddatetime`, `pp_end`, `pp_start`, `pro_status`) VALUES ('P3', 12, '2009-03-02', '2040-11-17', '2021-09-18', 'onhold');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pro_id`) VALUES ('I7', 'official', '2021-11-01', '2001-01-01', 'Spengergasse', 'value', 'P3');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_pr_id`) VALUES ('I8', 'official', '2021-11-01', '2001-01-01', 'Spengergasse', 'value', '9');
INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `pp_end`, `pp_start`, `i_system`, `i_value`, `i_p_id`) VALUES ('I9', 'official', '2021-11-01', '2001-01-01', 'Spengergasse', 'value', '3');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r1', 'ref', 'Photo', '1', 'abc');


INSERT INTO `spengermed`.`en_encounter` (`id`, `pp_end`, `pp_start`, `en_status`, `enc_subject_reference_fk`, `po_en_id`, `sj_en_id`) VALUES ('e1', now(), '2021-11-01', 'applied', 'n1', 'r1', 'r1'), ('e2', now(), now(), 'deletet', 'n1', 'r1' , 'r1' );

INSERT INTO `spengermed`.`sh_statushistory` (`id`, `pp_end`, `pp_start`, `sh_status`, `sh_en_id`) VALUES ('sh1', now(), '2021-11-01', 'failed', 'e1'), ('2', now(), now(), 'unknown', 'e1');

INSERT INTO `spengermed`.`pp_participant` (`id`, `pp_end`, `pp_start`, `in_pp_id`, `pp_en_id`) VALUES ('pp1', '2021-12-31', '2021-12-31', 'r1', 'e1');


INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc1', 'text', '10', 'pp1', 'e1');

INSERT INTO `spengermed`.`co_consent` (`id`, `co_datetime`, `co_sourcedatetime`, `co_status`, `enc_subject_reference_fk`, `cc_co_id`, `at_co_id`) VALUES ('co1', '2021-01-13', '2021-01-13', 'proposed', 'n1', 'cc1', 'a11');


INSERT INTO `spengermed`.`at_attachment` (`id`, `at_creation`, `at_data`, `at_hash`, `at_language`, `at_size`, `at_string`, `at_url`, `a_p_p_id`) VALUES ('a1', '2021-01-13', 'data:image//', '#', 'de', 14, 'hi', 'http:spengergasse.at', '1');

INSERT INTO `spengermed`.`d_diagnosis` (`id`, `d_rank`, `c_d_id`, `use_d_id`, `d_en_id`) VALUES ('1', '5', 'r1', 'cc1', 'e1');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc2', 'text', '10', 'pp1', 'e1');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r2', 'ref', 'Medication', '1', 'abc');

INSERT INTO `spengermed`.`se_suspectentity` (`id`, `r_se_id`) VALUES ('se1', 'r2');
INSERT INTO `spengermed`.`se_suspectentity` (`id`, `r_se_id`) VALUES ('se2', 'r2');

INSERT INTO `spengermed`.`ae_adverseevent` (`id`, `ae_code`, `ae_detected`, `enc_subject_reference_fk`, `i_ae_id`, `cc_ae_id`) VALUES ('ae1', 'actual', '2021-09-01', 'n1', 'i1', 'cc1');
INSERT INTO `spengermed`.`ae_adverseevent` (`id`, `ae_code`, `ae_detected`, `cc_ae_id`) VALUES ('ae2', 'potential', '2021-01-13', 'cc2');
INSERT INTO `spengermed`.`ae_adverseevent` (`id`, `ae_code`, `ae_detected`, `cc_ae_id`) VALUES ('ae20', 'actual ', '2021-01-13', 'cc1');


INSERT INTO `spengermed`.`qu_quantity` (`id`, `qu_code`, `qu_comparator`, `qu_system`, `qu_unit`, `qu_value`) VALUES ('qu1', 'Quantity', 'kl', 'spengergasse', 'Spengermed', '1');
INSERT INTO `spengermed`.`qu_quantity` (`id`, `qu_code`, `qu_comparator`, `qu_system`, `qu_unit`, `qu_value`) VALUES ('qu2', 'Quantity', 'kl', 'spengergasse', 'Spengermed', '1');
INSERT INTO `spengermed`.`qu_quantity` (`id`, `qu_code`, `qu_comparator`, `qu_system`, `qu_unit`, `qu_value`) VALUES ('qu3', 'Quantity', 'kl', 'spengergasse', 'Spengermed', '1');
INSERT INTO `spengermed`.`qu_quantity` (`id`, `qu_code`, `qu_comparator`, `qu_system`, `qu_unit`, `qu_value`) VALUES ('qu4', 'Quantity', 'kl', 'spengergasse', 'Spengermed', '1');

INSERT INTO `spengermed`.`rt_ratio` (`id`, `rt_dominator`, `rt_numerator`) VALUES ('rt1', 'qu1', 'qu2');
INSERT INTO `spengermed`.`ra_range` (`id`, `ra_high`, `ra_low`) VALUES ('ran1', '15', '5');
INSERT INTO `spengermed`.`sd_sampleddata` (`id`, `sd_data`, `sd_dimensions`, `sd_factor`, `sd_lowerlimit`, `sd_origin`, `sd_period`, `sd_upperlimit`) VALUES ('sd1', 'sampledData', '1', '1.5', '5', '10', '12', '100');

INSERT INTO `spengermed`.`ob_observation` (`id`, `ed_name`, `pp_end`, `pp_start`, `ob_status`, `ob_valueboolean`, `ob_valuedatetime`, `ob_valueinteger`, `ob_valuestring`, `ob_valuetime`, `enc_subject_reference_fk`, `co_cc_id`, `en_re_id`, `su_re_id`, `ob_valuquantity`, `ob_valuerange`, `ob_valueratio`, `ob_valuesampleddata`, `ob_valuecodableconcept`) VALUES ('ob1', '2021-01-01', '2021-01-01', '2020-01-01', 'registered', true, '2021-01-01', '4', 'strg', '10:30', 'n1', 'cc1', 'r1', 'r1', 'qu1', 'ran1', 'rt1', 'sd1', 'cc1');

/*Medication*/


INSERT INTO `spengermed`.`bat_batch` (`id`, `bat_expiration_date`, `bat_lot_number`) VALUES ('bat1', '2021-01-01', 'david');
INSERT INTO `spengermed`.`bat_batch` (`id`, `bat_expiration_date`, `bat_lot_number`) VALUES ('bat2', '2021-02-02', 'nichtdavid');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r23', 'ref', 'Photo', '1', 'abc');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r24', 'ref', 'Photo', '1', 'abc');

INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n11','additional','div');
INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n12','additional','div');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc30', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc31', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc32', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc33', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc34', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc35', 'text', '10', 'pp1', 'e1');

INSERT INTO `spengermed`.`rt_ratio` (`id`, `rt_dominator`, `rt_numerator`) VALUES ('rt2', 'qu3', 'qu4');

INSERT INTO `spengermed`.`me_medication` (`id`, `me_status`, `enc_subject_reference_fk`, `me_amount`, `me_batch`, `me_code`, `me_form`, `me_manufacturer`) VALUES ('med1', 'active ', 'n11', 'rt2', 'bat1', 'cc30', 'cc31', 'r23');
INSERT INTO `spengermed`.`me_medication` (`id`, `me_status`, `enc_subject_reference_fk`, `me_amount`, `me_batch`, `me_code`, `me_form`, `me_manufacturer`) VALUES ('med2', 'inactive ', 'n12', 'rt1', 'bat2', 'cc32', 'cc33', 'r24');

INSERT INTO `spengermed`.`ing_ingredient` (`id`, `ing_isactive`, `ing_itemcodeableconcept`, `ing_itemreference`, `ing_strength`, `me_ingredient`) VALUES ('ing1', True, 'cc34', 'r23', 'rt1', 'med1');
INSERT INTO `spengermed`.`ing_ingredient` (`id`, `ing_isactive`, `ing_itemcodeableconcept`, `ing_itemreference`, `ing_strength`, `me_ingredient`) VALUES ('ing2', False, 'cc35', 'r24', 'rt2', 'med2');

/*RiskAssessment*/

INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n51','additional','div');
INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n52','additional','div');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r63', 'ref', 'Photo', '1', 'abc');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r64', 'ref', 'Photo', '1', 'abc');

INSERT INTO `spengermed`.`ra_range` (`id`, `ra_high`, `ra_low`) VALUES ('ran70', '15', '5');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc81', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc82', 'text', '10', 'pp1', 'e1');

INSERT INTO `spengermed`.`ra_riskassessment` (`id`, `ra_status`, `enc_subject_reference_fk`, `ra_parent`) VALUES ('ra1', 'registered', 'n51', 'r63');
INSERT INTO `spengermed`.`ra_riskassessment` (`id`, `ra_status`, `enc_subject_reference_fk`, `ra_parent`) VALUES ('ra2', 'preliminary', 'n52', 'r64');

INSERT INTO `spengermed`.`pre_prediction` (`id`, `pre_probability_decimal`, `pre_outcome`, `ra_prediction`) VALUES ('pre1', '1', 'cc81', 'ra1');
INSERT INTO `spengermed`.`pre_prediction` (`id`, `pre_outcome`, `pre_probability_range`, `ra_prediction`) VALUES ('pre2', 'cc82', 'ran70', 'ra2');

/*Invoice*/
INSERT INTO `spengermed`.`n_narrative` (`id`,`n_status`,`n_div`) VALUES ('n61','additional','div');
INSERT INTO `spengermed`.`in_invoice` (`id`, `enc_subject_reference_fk`) VALUES ('in1', 'n61');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cc_pr_id`, `t_pp_id`, `t_en_id`) VALUES ('cc91', 'text', '10', 'pp1', 'e1');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`, `r_type`, `r_p_id`, `r_display`) VALUES ('r73', 'ref', 'Photo', '1', 'abc');


INSERT INTO `spengermed`.`li_lineitem` (`id`, `li_sequence`, `li_cc_charge_item_codeable_concept`, `in_li_lineitem`) VALUES ('li1', '1', 'cc91', 'in1');
INSERT INTO `spengermed`.`li_lineitem` (`id`, `li_sequence`, `li_r_charge_item_reference`, `in_li_lineitem`) VALUES ('li1', '1', 'r73', 'in1');

INSERT INTO `spengermed`.`pc_pricecomponent` (`id`, `pc_type`, `li_price_component`) VALUES ('pc1', 'base ', 'li1');
INSERT INTO `spengermed`.`pc_pricecomponent` (`id`, `pc_type`, `li_price_component`) VALUES ('pc2', 'surcharge  ', 'li2');

/*EpisodeOfCare*/

INSERT INTO `spengermed`.`en_encounter` (`id`, `pp_end`, `pp_start`, `en_status`, `enc_subject_reference_fk`, `po_en_id`, `sj_en_id`) VALUES ('e40', now(), '2021-11-01', 'applied', 'n1', 'r1', 'r1'), ('e41', now(), now(), 'deletet', 'n1', 'r1' , 'r1' );

INSERT INTO `spengermed`.`sh_statushistory` (`id`, `pp_end`, `pp_start`, `sh_status`, `sh_en_id`) VALUES ('sh50', now(), '2021-11-01', 'failed', 'e40'), ('sh51', now(), now(), 'unknown', 'e41');

INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n71','additional','div');
INSERT INTO `spengermed`.`n_narrative`(`id`,`n_status`,`n_div`) VALUES ('n72','additional','div');

INSERT INTO `spengermed`.`eoc_episodeofcare` (`id`, `eoc_status`, `enc_subject_reference_fk`) VALUES ('eoc1', 'waitlist', 'n71');
INSERT INTO `spengermed`.`eoc_episodeofcare` (`id`, `eoc_status`, `enc_subject_reference_fk`) VALUES ('eoc2', 'planned', 'n72');

/*Immunization*/

INSERT INTO `spengermed`.`i_identifier` (`id`, `i_system`, `i_value`) VALUES ('I10', 'urn:ietf:rfc:3986', 'urn:oid:1.3.6.1.4.1.21367.2005.3.7.1234');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc101', 'Fluvax (Influenza)');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_cc_id`) VALUES ('c1', 'FLUVAX', 'urn:oid:1.2.36.1.2001.1005.17', 'cc101');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r83', 'Patient/example');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r84', 'Encounter/example');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r85', 'Organization/hl7');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`) VALUES ('cc102');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c2', 'LA', 'left arm', 'http://terminology.hl7.org/CodeSystem/v3-ActSite', 'cc102');

INSERT INTO `spengermed`.`qu_quantity` (`id`, `qu_code`, `qu_system`, `qu_value`) VALUES ('qu5', 'mg', 'http://unitsofmeasure.org', '5');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`) VALUES ('cc103');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_cc_id`) VALUES ('c3', 'OP', 'http://terminology.hl7.org/CodeSystem/v2-0443', 'cc103');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r86', 'Practitioner/example');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r87', 'Practitioner/example1');


INSERT INTO `spengermed`.`cc_codeableconcept` (`id`) VALUES ('cc104');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_cc_id`) VALUES ('c4', 'AP', 'http://terminology.hl7.org/CodeSystem/v2-0443', 'cc104');
INSERT INTO `spengermed`.`n_narrative` (`id`,`n_status`,`n_div`) VALUES ('n81','generated','<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p><b>Generated Narrative with Details</b></p><p><b>id</b>: example</p><p><b>identifier</b>: urn:oid:1.3.6.1.4.1.21367.2005.3.7.1234</p><p><b>status</b>: completed</p><p><b>vaccineCode</b>: Fluvax (Influenza) <span>(Details : {urn:oid:1.2.36.1.2001.1005.17 code \FLUVAX\ = \Fluvax)</span></p><p><b>patient</b>: <a>Patient/example</a></p><p><b>encounter</b>: <a>Encounter/example</a></p><p><b>occurrence</b>: 10/01/2013</p><p><b>primarySource</b>: true</p><p><b>location</b>: <a>Location/1</a></p><p><b>manufacturer</b>: <a>Organization/hl7</a></p><p><b>lotNumber</b>: AAJN11K</p><p><b>expirationDate</b>: 15/02/2015</p><p><b>site</b>: left arm <span>(Details : {http://terminology.hl7.org/CodeSystem/v3-ActSite code \LA\ = \left arm\, given as \left arm\})</span></p><p><b>route</b>: Injection, intramuscular <span>(Details : {http://terminology.hl7.org/CodeSystem/v3-RouteOfAdministration code \IM\ = \Injection, intramuscular\, given as \Injection, intramuscular\})</span></p><p><b>doseQuantity</b>: 5 mg<span> (Details: UCUM code mg = \mg\)</span></p><blockquote><p><b>performer</b></p><p><b>function</b>: Ordering Provider <span>(Details : {http://terminology.hl7.org/CodeSystem/v2-0443 code \OP\ = \Ordering Provider)</span></p><p><b>actor</b>: <a>Practitioner/example</a></p></blockquote><blockquote><p><b>performer</b></p><p><b>function</b>: Administering Provider <span>(Details : {http://terminology.hl7.org/CodeSystem/v2-0443 code \AP\ = \Administering Provider)</span></p><p><b>actor</b>: <a>Practitioner/example</a></p></blockquote><p><b>note</b>: Notes on adminstration of vaccine</p><p><b>reasonCode</b>: Procedure to meet occupational requirement <span>(Details : {SNOMED CT code \429060002\ = \Procedure to meet occupational requirement)</span></p><p><b>isSubpotent</b>: true</p><h3>Educations</h3><table><tr><td>-</td><td><b>DocumentType</b></td><td><b>PublicationDate</b></td><td><b>PresentationDate</b></td></tr><tr><td>*</td><td>253088698300010311120702</td><td>02/07/2012</td><td>10/01/2013</td></tr></table><p><b>programEligibility</b>: Not Eligible <span>(Details : {http://terminology.hl7.org/CodeSystem/immunization-program-eligibility code \ineligible\ = \Not Eligible)</span></p><p><b>fundingSource</b>: Private <span>(Details : {http://terminology.hl7.org/CodeSystem/immunization-funding-source code \private\ = \Private)</span></p></div>');

INSERT INTO `spengermed`.`im_immunization` (`id`, `im_expirationdate`, `im_lotnumber`, `im_occurrencedatetime`, `im_occurrencestring`, `im_status`, `enc_subject_reference_fk`, `im_dosequantity`, `im_encounter`, `im_manufacturer`, `im_patient`, `im_site`, `im_vaccinecode`) VALUES ('example', '2015-02-15', 'AAJN11K', '2013-01-10', '', 'completed', 'n81', 'qu5', 'r84', 'r85', 'r83', 'cc102', 'cc101');
INSERT INTO `spengermed`.`im_immunization` (`id`, `im_expirationdate`, `im_lotnumber`, `im_occurrencedatetime`, `im_occurrencestring`, `im_status`, `enc_subject_reference_fk`, `im_dosequantity`, `im_encounter`, `im_manufacturer`, `im_patient`, `im_site`, `im_vaccinecode`) VALUES ('example1', '2015-02-15', 'AAJN11K', '2013-01-10', '', 'completed', 'n81', 'qu5', 'r84', 'r85', 'r83', 'cc102', 'cc101');

INSERT INTO `spengermed`.`pe_performer` (`id`, `pe_actor`, `pe_function`, `im_performer`) VALUES ('pe1', 'r86', 'cc103', 'example');
INSERT INTO `spengermed`.`pe_performer` (`id`, `pe_actor`, `pe_function`, `im_performer`) VALUES ('pe2', 'r87', 'cc104', 'example');

/*LINKAGE*/

INSERT INTO `spengermed`.`r_reference` (`id`, `r_display`, `r_reference`) VALUES ('r97', 'Severe burn of left ear (Date: 24-May 2012)', 'Condition/example');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_display`, `r_reference`) VALUES ('r98', 'Severe burn of left ear (Date: 24-May 2012)', 'Condition/condition-example');
INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r99', 'Practitioner/f201');

INSERT INTO `spengermed`.`n_narrative` (`id`,`n_status`,`n_div`) VALUES ('n91','generated','<div xmlns=\"http://www.w3.org/1999/xhtml\">\n<p><b>Source:</b> Condition/example - <i>Severe burn of left ear (Date: 24-May 2012)</i></p>\n <p><b>Alternate:</b> Condition/condition-example -<i>Severe burn of left ear (Date: 24-May 2012)</i></p>\n </div>');

INSERT INTO `spengermed`.`lin_linkage` (`id`, `enc_subject_reference_fk`, `lin_author`) VALUES ('examplelinkage', 'n91', 'r99');

INSERT INTO `spengermed`.`it_item` (`id`, `it_type`, `it_resource`, `lin_item`) VALUES ('it1', 'source', 'r97', 'examplelinkage');
INSERT INTO `spengermed`.`it_item` (`id`, `it_type`, `it_resource`, `lin_item`) VALUES ('it2', 'alternate', 'r98', 'examplelinkage');

/*CONDITION*/

INSERT INTO `spengermed`.`n_narrative` (`id`,`n_status`,`n_div`) VALUES ('n101','generated','<div xmlns=\"http://www.w3.org/1999/xhtml\">Severe burn of left ear (Date: 24-May 2012)</div>');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc111', 'clinicalStatus');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_cc_id`) VALUES ('c5', 'active', 'http://terminology.hl7.org/CodeSystem/condition-clinical', 'cc111');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc112', 'verificationStatus');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_cc_id`) VALUES ('c6', 'confirmed', 'http://terminology.hl7.org/CodeSystem/condition-ver-status', 'cc112');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc114', 'severity');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c9', '24484000', 'Severe', 'http://snomed.info/sct', 'cc114');
INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`) VALUES ('cc115', 'Burnt Ear');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c10', '39065001', 'Burn of ear', 'http://snomed.info/sct', 'cc115');

INSERT INTO `spengermed`.`r_reference` (`id`, `r_reference`) VALUES ('r101', 'Patient/example');
INSERT INTO `spengermed`.`cd_condition` (`id`, `enc_subject_reference_fk`, `cd_cc_clinicalstatus`, `cd_cc_code`, `cd_cc_severity`, `cd_re_subject_patient`, `cd_cc_verificationstatus`) VALUES ('cd1', 'n101', 'cc111', 'cc115', 'cc114', 'r101', 'cc112');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cd_cc_category`) VALUES ('cc113', 'cdcategory', 'cd1');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c7', 'encounter-diagnosis', 'Encounter Diagnosis', 'http://terminology.hl7.org/CodeSystem/condition-category', 'cc113');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c8', '439401001', 'Diagnosis', 'http://snomed.info/sct', 'cc113');

INSERT INTO `spengermed`.`cc_codeableconcept` (`id`, `cc_text`, `cd_cc_bodysite`) VALUES ('cc116', 'Left Ear', 'cd1');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_display`, `c_system`, `c_cc_id`) VALUES ('c11', '49521004', 'Left external ear structure', 'http://snomed.info/sct', 'cc116');

/*MEASURE*/

INSERT INTO `spengermed`.`i_identifier` (`id`, `i_code`, `i_value`) VALUES ('I10', 'official', 'exclusive-breastfeeding-measure');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_display`) VALUES ('c6', '260385009', 'http://snomed.info/sct', 'Negative');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_code`, `c_system`, `c_display`) VALUES ('c7', 'NEG', 'https://acme.lab/resultcodes', 'Negative');


/*ImagingStudy*/

INSERT INTO `spengermed`.`is_imagingstudy` (`id`, `is_description`,`is_status`) VALUES ('II12','hallo','registered');
INSERT INTO `spengermed`.`i_identifier` (`id`,`i_system`,`i_value`,`is_i_id`) VALUES ('I10','dicom','urn','II12');

INSERT INTO `spengermed`.`is_imagingstudy` (`id`, `is_started`,`is_number_Of_Series`,`is_description`) VALUES ('HT12','201-01-01',1,'DICOMimage');
INSERT INTO `spengermed`.`se_series` (`id`,`se_number`,`se_uid`,`is_se_id`) VALUES ('j12',3,'urn:oid:543','HT12');
INSERT INTO `spengermed`.`c_coding` (`id`, `c_system`,`c_code`) VALUES ('j12','http://nema','CT');
