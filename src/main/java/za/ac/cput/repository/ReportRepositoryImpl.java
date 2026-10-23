
// /*
// ReportRepositoryImpl.java
// Report Repository Implementation Class
// Author: Nolwazi Zulu (220118876)
// Date: 22 October 2026
// */

// package za.ac.cput.repository;

// import za.ac.cput.domain.Report;

// import java.util.HashMap;
// import java.util.Map;

// public class ReportRepositoryImpl implements ReportRepository {

//     private static final ReportRepositoryImpl REPOSITORY =
//             new ReportRepositoryImpl();

//     private final Map<Long, Report> reportDB = new HashMap<>();

//     private ReportRepositoryImpl() {
//     }

//     public static ReportRepositoryImpl getRepository() {
//         return REPOSITORY;
//     }

//     @Override
//     public Report create(Report report) {
//         if (report == null || report.getReportId() == null) {
//             return null;
//         }

//         reportDB.put(report.getReportId(), report);
//         return report;
//     }

//     @Override
//     public Report read(Long id) {
//         if (id == null) {
//             return null;
//         }

//         return reportDB.get(id);
//     }

//     @Override
//     public Report update(Report report) {
//         if (report == null || report.getReportId() == null) {
//             return null;
//         }

//         Long id = report.getReportId();

//         if (!reportDB.containsKey(id)) {
//             return null;
//         }

//         reportDB.put(id, report);
//         return report;
//     }

//     @Override
//     public boolean delete(Long id) {
//         if (id == null) {
//             return false;
//         }

//         return reportDB.remove(id) != null;
//     }
// }
