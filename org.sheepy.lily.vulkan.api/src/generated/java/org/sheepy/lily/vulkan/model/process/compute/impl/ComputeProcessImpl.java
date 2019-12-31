/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;

import org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl#getPipelinePkg <em>Pipeline Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputeProcessImpl extends AbstractProcessImpl implements ComputeProcess
{
	/**
	 * The cached value of the '{@link #getPipelinePkg() <em>Pipeline Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelinePkg()
	 * @generated
	 * @ordered
	 */
	protected PipelinePkg pipelinePkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeProcessImpl()
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
		return ComputePackage.Literals.COMPUTE_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PipelinePkg getPipelinePkg()
	{
		return pipelinePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPipelinePkg(PipelinePkg newPipelinePkg, NotificationChain msgs)
	{
		PipelinePkg oldPipelinePkg = pipelinePkg;
		pipelinePkg = newPipelinePkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, oldPipelinePkg, newPipelinePkg);
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
	public void setPipelinePkg(PipelinePkg newPipelinePkg)
	{
		if (newPipelinePkg != pipelinePkg)
		{
			NotificationChain msgs = null;
			if (pipelinePkg != null)
				msgs = ((InternalEObject)pipelinePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, null, msgs);
			if (newPipelinePkg != null)
				msgs = ((InternalEObject)newPipelinePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, null, msgs);
			msgs = basicSetPipelinePkg(newPipelinePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG, newPipelinePkg, newPipelinePkg));
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return basicSetPipelinePkg(null, msgs);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return getPipelinePkg();
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)newValue);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				setPipelinePkg((PipelinePkg)null);
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
			case ComputePackage.COMPUTE_PROCESS__PIPELINE_PKG:
				return pipelinePkg != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputeProcessImpl
