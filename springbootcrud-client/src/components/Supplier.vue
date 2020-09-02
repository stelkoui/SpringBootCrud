<template>
  <el-dialog type="warning" title="Διαχείριση Προμηθευτή" :visible="visible" :modal="true"
             :close-on-click-modal="false"
             :close-on-press-escape="false" :modal-append-to-body="false" :show-close="false" width="75%"
             @close="clearValidation">

    <el-card>
      <el-form ref="supplierForm" :model="supplier" :rules="rules" label-position="top">

        <el-row :gutter="20">
          <!-- LEFT COLUMN -->
          <el-col :span="12">

            <el-form-item label="Εισάγετε το όνομα της εταιρίας"
                          prop="companyName">
              <el-input prefix-icon="fa fa-company"
                        v-model="supplier.companyName"
                        placeholder="name"
                        autoComplete="companyName">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε τον αριθμό των vat"
                          prop="vatNumber">
              <el-input prefix-icon="fa fa-vat"
                        v-model="supplier.vatNumber"
                        placeholder="Vat"
                        autoComplete="vat">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε το όνομα του προμηθευτή"
                          prop="firstName">
              <el-input prefix-icon="fa fa-envelope"
                        v-model="supplier.firstName"
                        placeholder="firstname"
                        autoComplete="name">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε το επίθετο του προμηθευτή"
                          prop="lastName">
              <el-input prefix-icon="fa fa-envelope"
                        v-model="supplier.lastName"
                        placeholder="lastname"
                        autoComplete="name">
              </el-input>
            </el-form-item>
          </el-col>

          <!-- RIGHT COLUMN -->
          <el-col :span="12">

            <el-form-item label="Συμπληρώστε την πόλη"
                          prop="city">
              <el-input
                prefix-icon="fa fa-city"
                v-model="supplier.city"
                placeholder="city"
                auto-complete="city">
              </el-input>
            </el-form-item>

            <el-form-item label="Συμπληρώστε την χώρα"
                          prop="country">
              <el-input
                prefix-icon="fa fa-country"
                v-model="supplier.country"
                placeholder="country"
                auto-complete="country">
              </el-input>
            </el-form-item>

            <el-form-item label="Διεύθυνση"
                          prop="address">
              <el-input
                prefix-icon="fa fa-address"
                v-model="supplier.address"
                placeholder="address"
                auto-complete="address">
              </el-input>
            </el-form-item>

            <el-form-item label="Ταχ.Κώδικας"
                          prop="zipCode">
              <el-input
                prefix-icon="fa fa-code"
                v-model="supplier.zipCode"
                placeholder="zipcode"
                auto-complete="zipcode">
              </el-input>
            </el-form-item>

          </el-col>
        </el-row>

      </el-form>

      <el-row>
        <el-col style="text-align: right">
          <el-button type="success"
                     icon="fa fa-save"
                     @click="save"> Αποθήκευση
          </el-button>

          <el-button type="danger"
                     icon="fa fa-remove"
                     @click="confirmDelete"
                     :disabled="!isDeletable"> Διαγραφή
          </el-button>
        </el-col>
      </el-row>
    </el-card>

    <div slot="footer" class="dialog-footer card-footer">
      <el-button type="warning"
                 icon="el-icon-back"
                 @click="cancel"> Επιστροφή
      </el-button>
    </div>

  </el-dialog>
</template>
<script src="./SupplierVM.js"></script>
