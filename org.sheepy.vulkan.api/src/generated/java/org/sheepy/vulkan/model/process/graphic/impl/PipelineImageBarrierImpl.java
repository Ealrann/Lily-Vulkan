/**
 */
package org.sheepy.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.vulkan.model.process.graphic.PipelineImageBarrier;

import org.sheepy.vulkan.model.process.impl.PipelineBarrierImpl;

import org.sheepy.vulkan.model.resource.ImageBarrier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Image Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.impl.PipelineImageBarrierImpl#getImageBarrier <em>Image Barrier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelineImageBarrierImpl extends PipelineBarrierImpl implements PipelineImageBarrier
{
	/**
	 * The cached value of the '{@link #getImageBarrier() <em>Image Barrier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageBarrier()
	 * @generated
	 * @ordered
	 */
	protected ImageBarrier imageBarrier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipelineImageBarrierImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.PIPELINE_IMAGE_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImageBarrier getImageBarrier()
	{
		return imageBarrier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImageBarrier(ImageBarrier newImageBarrier, NotificationChain msgs)
	{
		ImageBarrier oldImageBarrier = imageBarrier;
		imageBarrier = newImageBarrier;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER, oldImageBarrier, newImageBarrier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImageBarrier(ImageBarrier newImageBarrier)
	{
		if (newImageBarrier != imageBarrier)
		{
			NotificationChain msgs = null;
			if (imageBarrier != null)
				msgs = ((InternalEObject)imageBarrier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER, null, msgs);
			if (newImageBarrier != null)
				msgs = ((InternalEObject)newImageBarrier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER, null, msgs);
			msgs = basicSetImageBarrier(newImageBarrier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER, newImageBarrier, newImageBarrier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER:
				return basicSetImageBarrier(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER:
				return getImageBarrier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER:
				setImageBarrier((ImageBarrier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER:
				setImageBarrier((ImageBarrier)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicPackage.PIPELINE_IMAGE_BARRIER__IMAGE_BARRIER:
				return imageBarrier != null;
		}
		return super.eIsSet(featureID);
	}

} //PipelineImageBarrierImpl
