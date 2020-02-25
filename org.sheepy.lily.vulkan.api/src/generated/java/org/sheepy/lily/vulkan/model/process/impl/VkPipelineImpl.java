/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.VkPipeline;

import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.DescriptorSet;
import org.sheepy.lily.vulkan.model.resource.DescriptorSetPkg;

import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vk Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl#getDescriptorSetPkg <em>Descriptor Set Pkg</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl#getSpecializationData <em>Specialization Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl#getPushConstantRanges <em>Push Constant Ranges</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.VkPipelineImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VkPipelineImpl extends TaskPipelineImpl implements VkPipeline
{
	/**
	 * The cached value of the '{@link #getDescriptorSetPkg() <em>Descriptor Set Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescriptorSetPkg()
	 * @generated
	 * @ordered
	 */
	protected DescriptorSetPkg descriptorSetPkg;

	/**
	 * The cached value of the '{@link #getSpecializationData() <em>Specialization Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationData()
	 * @generated
	 * @ordered
	 */
	protected ConstantBuffer specializationData;

	/**
	 * The cached value of the '{@link #getPushConstantRanges() <em>Push Constant Ranges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPushConstantRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<PushConstantRange> pushConstantRanges;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptorSet> layout;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VkPipelineImpl()
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
		return ProcessPackage.Literals.VK_PIPELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptorSetPkg getDescriptorSetPkg()
	{
		return descriptorSetPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescriptorSetPkg(DescriptorSetPkg newDescriptorSetPkg, NotificationChain msgs)
	{
		DescriptorSetPkg oldDescriptorSetPkg = descriptorSetPkg;
		descriptorSetPkg = newDescriptorSetPkg;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG, oldDescriptorSetPkg, newDescriptorSetPkg);
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
	public void setDescriptorSetPkg(DescriptorSetPkg newDescriptorSetPkg)
	{
		if (newDescriptorSetPkg != descriptorSetPkg)
		{
			NotificationChain msgs = null;
			if (descriptorSetPkg != null)
				msgs = ((InternalEObject)descriptorSetPkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG, null, msgs);
			if (newDescriptorSetPkg != null)
				msgs = ((InternalEObject)newDescriptorSetPkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG, null, msgs);
			msgs = basicSetDescriptorSetPkg(newDescriptorSetPkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG, newDescriptorSetPkg, newDescriptorSetPkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getSpecializationData()
	{
		if (specializationData != null && ((EObject)specializationData).eIsProxy())
		{
			InternalEObject oldSpecializationData = specializationData;
			specializationData = (ConstantBuffer)eResolveProxy(oldSpecializationData);
			if (specializationData != oldSpecializationData)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA, oldSpecializationData, specializationData));
			}
		}
		return specializationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBuffer basicGetSpecializationData()
	{
		return specializationData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpecializationData(ConstantBuffer newSpecializationData)
	{
		ConstantBuffer oldSpecializationData = specializationData;
		specializationData = newSpecializationData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA, oldSpecializationData, specializationData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PushConstantRange> getPushConstantRanges()
	{
		if (pushConstantRanges == null)
		{
			pushConstantRanges = new EObjectContainmentEList<PushConstantRange>(PushConstantRange.class, this, ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES);
		}
		return pushConstantRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DescriptorSet> getLayout()
	{
		if (layout == null)
		{
			layout = new EObjectResolvingEList<DescriptorSet>(DescriptorSet.class, this, ProcessPackage.VK_PIPELINE__LAYOUT);
		}
		return layout;
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
			case ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG:
				return basicSetDescriptorSetPkg(null, msgs);
			case ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES:
				return ((InternalEList<?>)getPushConstantRanges()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG:
				return getDescriptorSetPkg();
			case ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA:
				if (resolve) return getSpecializationData();
				return basicGetSpecializationData();
			case ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES:
				return getPushConstantRanges();
			case ProcessPackage.VK_PIPELINE__LAYOUT:
				return getLayout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG:
				setDescriptorSetPkg((DescriptorSetPkg)newValue);
				return;
			case ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA:
				setSpecializationData((ConstantBuffer)newValue);
				return;
			case ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES:
				getPushConstantRanges().clear();
				getPushConstantRanges().addAll((Collection<? extends PushConstantRange>)newValue);
				return;
			case ProcessPackage.VK_PIPELINE__LAYOUT:
				getLayout().clear();
				getLayout().addAll((Collection<? extends DescriptorSet>)newValue);
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
			case ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG:
				setDescriptorSetPkg((DescriptorSetPkg)null);
				return;
			case ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA:
				setSpecializationData((ConstantBuffer)null);
				return;
			case ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES:
				getPushConstantRanges().clear();
				return;
			case ProcessPackage.VK_PIPELINE__LAYOUT:
				getLayout().clear();
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
			case ProcessPackage.VK_PIPELINE__DESCRIPTOR_SET_PKG:
				return descriptorSetPkg != null;
			case ProcessPackage.VK_PIPELINE__SPECIALIZATION_DATA:
				return specializationData != null;
			case ProcessPackage.VK_PIPELINE__PUSH_CONSTANT_RANGES:
				return pushConstantRanges != null && !pushConstantRanges.isEmpty();
			case ProcessPackage.VK_PIPELINE__LAYOUT:
				return layout != null && !layout.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VkPipelineImpl
