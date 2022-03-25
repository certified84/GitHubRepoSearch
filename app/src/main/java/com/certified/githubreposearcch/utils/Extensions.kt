package com.certified.githubreposearcch.utils

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.browser.customtabs.*
import androidx.core.content.res.ResourcesCompat
import com.certified.githubreposearcch.R
import com.certified.githubreposearcch.utils.Config.CUSTOM_PACKAGE_NAME

object Extensions {

    fun Context.openBrowser(url: String) {
        try {
            val packageManager = this.packageManager
            packageManager.getPackageInfo(CUSTOM_PACKAGE_NAME, 0)
            showChromeCustomTabView(url, this)
        } catch (e: PackageManager.NameNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }

    private fun showChromeCustomTabView(url: String, context: Context) {
        var customTabsClient: CustomTabsClient?
        var customTabsSession: CustomTabsSession? = null
        val customTabsServiceConnection: CustomTabsServiceConnection =
            object : CustomTabsServiceConnection() {
                override fun onServiceDisconnected(name: ComponentName?) {
                    customTabsClient = null
                }

                override fun onCustomTabsServiceConnected(
                    name: ComponentName,
                    client: CustomTabsClient
                ) {
                    customTabsClient = client
                    customTabsClient!!.warmup(0L)
                    customTabsSession = customTabsClient!!.newSession(null)
                }
            }
        CustomTabsClient.bindCustomTabsService(
            context,
            CUSTOM_PACKAGE_NAME,
            customTabsServiceConnection
        )
        val customTabsIntent = CustomTabsIntent.Builder(customTabsSession)
            .setShowTitle(true).setDefaultColorSchemeParams(
                CustomTabColorSchemeParams.Builder().setToolbarColor(
                    ResourcesCompat.getColor(
                        context.resources,
                        R.color.colorPrimary,
                        null
                    )
                ).build()
            ).build()

        customTabsIntent.launchUrl(context, Uri.parse(url))
    }
}