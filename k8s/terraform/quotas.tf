resource "kubernetes_resource_quota" "tenant_a_quota" {
  metadata {
    name      = "tenant-a-quota"
    namespace = kubernetes_namespace.tenant_a.metadata[0].name
  }

  spec {
    hard = {
      "requests.cpu"    = "1"
      "requests.memory" = "1Gi"
      "limits.cpu"      = "2"
      "limits.memory"   = "2Gi"
      "pods"            = "5"
    }
  }
}
