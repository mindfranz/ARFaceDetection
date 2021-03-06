package com.cleveroad.arfacedetector.ui.screens.main.arcore.face_detector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.ux.ArFragment

internal class FaceDetectorFragment : ArFragment() {

    companion object {
        fun newInstance() = FaceDetectorFragment().apply {
            arguments = Bundle()
        }
    }

    override fun getSessionConfiguration(session: Session?): Config =
            Config(session).apply {
                augmentedFaceMode = Config.AugmentedFaceMode.MESH3D
            }

    override fun getSessionFeatures(): MutableSet<Session.Feature> =
            mutableSetOf(Session.Feature.FRONT_CAMERA)

    /**
     * Override to turn off planeDiscoveryController. Plane trackables are not supported with the
     * front camera.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val frameLayout = super.onCreateView(inflater, container, savedInstanceState) as? FrameLayout

        planeDiscoveryController.run {
            hide()
            setInstructionView(null)
        }

        return frameLayout
    }
}