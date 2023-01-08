/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionRecorderImpl#getSubmission <em>Submission</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionRecorderImpl#getCommandBuffer <em>Command Buffer</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputeExecutionRecorderImpl extends LilyEObject implements ComputeExecutionRecorder
{
	/**
	 * The cached value of the '{@link #getSubmission() <em>Submission</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubmission()
	 * @generated
	 * @ordered
	 */
	protected Submission submission;
	/**
	 * The cached value of the '{@link #getCommandBuffer() <em>Command Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandBuffer()
	 * @generated
	 * @ordered
	 */
	protected ComputeCommandBuffer commandBuffer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeExecutionRecorderImpl()
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
		return ComputePackage.Literals.COMPUTE_EXECUTION_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Submission getSubmission()
	{
		return submission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubmission(Submission newSubmission, NotificationChain msgs)
	{
		Submission oldSubmission = submission;
		submission = newSubmission;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION, oldSubmission, newSubmission);
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
	public void setSubmission(Submission newSubmission)
	{
		if (newSubmission != submission)
		{
			NotificationChain msgs = null;
			if (submission != null)
				msgs = ((InternalEObject)submission).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION, null, msgs);
			if (newSubmission != null)
				msgs = ((InternalEObject)newSubmission).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION, null, msgs);
			msgs = basicSetSubmission(newSubmission, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION, newSubmission, newSubmission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComputeCommandBuffer getCommandBuffer()
	{
		if (commandBuffer != null && ((EObject)commandBuffer).eIsProxy())
		{
			InternalEObject oldCommandBuffer = commandBuffer;
			commandBuffer = (ComputeCommandBuffer)eResolveProxy(oldCommandBuffer);
			if (commandBuffer != oldCommandBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER, oldCommandBuffer, commandBuffer));
			}
		}
		return commandBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeCommandBuffer basicGetCommandBuffer()
	{
		return commandBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommandBuffer(ComputeCommandBuffer newCommandBuffer)
	{
		ComputeCommandBuffer oldCommandBuffer = commandBuffer;
		commandBuffer = newCommandBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER, oldCommandBuffer, commandBuffer));
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
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION:
				return basicSetSubmission(null, msgs);
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
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION:
				return getSubmission();
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER:
				if (resolve) return getCommandBuffer();
				return basicGetCommandBuffer();
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
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION:
				setSubmission((Submission)newValue);
				return;
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER:
				setCommandBuffer((ComputeCommandBuffer)newValue);
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
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION:
				setSubmission((Submission)null);
				return;
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER:
				setCommandBuffer((ComputeCommandBuffer)null);
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
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__SUBMISSION:
				return submission != null;
			case ComputePackage.COMPUTE_EXECUTION_RECORDER__COMMAND_BUFFER:
				return commandBuffer != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputeExecutionRecorderImpl
