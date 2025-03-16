package EJB.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "\"__EFMigrationsHistory\"")
public class Efmigrationshistory {
    @Id
    @Size(max = 150)
    @Column(name = "\"MigrationId\"", nullable = false, length = 150)
    private String migrationId;

    @Size(max = 32)
    @NotNull
    @Column(name = "\"ProductVersion\"", nullable = false, length = 32)
    private String productVersion;

    public String getMigrationId() {
        return migrationId;
    }

    public void setMigrationId(String migrationId) {
        this.migrationId = migrationId;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

}