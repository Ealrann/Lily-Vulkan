/**
 */
package org.sheepy.vulkan.model.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.vulkan.model.enumeration.ECommandStage;

import org.sheepy.vulkan.model.process.AbstractPipeline;
import org.sheepy.vulkan.model.process.ProcessPackage;

import org.sheepy.vulkan.model.resource.DescriptorSet;
import org.sheepy.vulkan.model.resource.PushConstant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl#getStage <em>Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl#getDescriptorSet <em>Descriptor Set</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.impl.AbstractPipelineImpl#getPushConstant <em>Push Constant</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractPipelineImpl extends MinimalEObjectImpl.Container implements AbstractPipeline
{
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final ECommandStage STAGE_EDEFAULT = ECommandStage.RENDER;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected ECommandStage stage = STAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescriptorSet() <em>Descriptor Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSet()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSet descriptorSet;

	/**
	 * The cached value of the '{@link #getPushConstant() <em>Push Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushConstant()
	 * @generated
	 * @ordered
	 */
	protected PushConstant pushConstant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractPipelineImpl()
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
		return ProcessPackage.Literals.ABSTRACT_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECommandStage getStage()
	{
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStage(ECommandStage newStage)
	{
		ECommandStage oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet getDescriptorSet()
	{
		if (descriptorSet != null && descriptorSet.eIsProxy())
		{
			InternalEObject oldDescriptorSet = (InternalEObject)descriptorSet;
			descriptorSet = (DescriptorSet)eResolveProxy(oldDescriptorSet);
			if (descriptorSet != oldDescriptorSet)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET, oldDescriptorSet, descriptorSet));
			}
		}
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptorSet basicGetDescriptorSet()
	{
		return descriptorSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescriptorSet(DescriptorSet newDescriptorSet)
	{
		DescriptorSet oldDescriptorSet = descriptorSet;
		descriptorSet = newDescriptorSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET, oldDescriptorSet, descriptorSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PushConstant getPushConstant()
	{
		return pushConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPushConstant(PushConstant newPushConstant, NotificationChain msgs)
	{
		PushConstant oldPushConstant = pushConstant;
		pushConstant = newPushConstant;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT, oldPushConstant, newPushConstant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPushConstant(PushConstant newPushConstant)
	{
		if (newPushConstant != pushConstant)
		{
			NotificationChain msgs = null;
			if (pushConstant != null)
				msgs = ((InternalEObject)pushConstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT, null, msgs);
			if (newPushConstant != null)
				msgs = ((InternalEObject)newPushConstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT, null, msgs);
			msgs = basicSetPushConstant(newPushConstant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT, newPushConstant, newPushConstant));
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
			case ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT:
				return basicSetPushConstant(null, msgs);
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
			case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
				return isEnabled();
			case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
				return getStage();
			case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
				if (resolve) return getDescriptorSet();
				return basicGetDescriptorSet();
			case ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT:
				return getPushConstant();
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
			case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
				setStage((ECommandStage)newValue);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
				setDescriptorSet((DescriptorSet)newValue);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT:
				setPushConstant((PushConstant)newValue);
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
			case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
				setStage(STAGE_EDEFAULT);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
				setDescriptorSet((DescriptorSet)null);
				return;
			case ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT:
				setPushConstant((PushConstant)null);
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
			case ProcessPackage.ABSTRACT_PIPELINE__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case ProcessPackage.ABSTRACT_PIPELINE__STAGE:
				return stage != STAGE_EDEFAULT;
			case ProcessPackage.ABSTRACT_PIPELINE__DESCRIPTOR_SET:
				return descriptorSet != null;
			case ProcessPackage.ABSTRACT_PIPELINE__PUSH_CONSTANT:
				return pushConstant != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(", stage: ");
		result.append(stage);
		result.append(')');
		return result.toString();
	}

} //AbstractPipelineImpl
