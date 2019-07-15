/**
 */
package org.sheepy.vulkan.model.pipeline.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

import org.sheepy.vulkan.model.pipeline.PipelinePackage;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Push Constant Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl#getStages <em>Stages</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PushConstantRangeImpl extends MinimalEObjectImpl.Container implements PushConstantRange
{
	/**
	 * The cached value of the '{@link #getStages() <em>Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EShaderStage> stages;

	/**
	 * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOffset()
	 * @generated
	 * @ordered
	 */
	protected int offset = OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PushConstantRangeImpl()
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
		return PipelinePackage.Literals.PUSH_CONSTANT_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EShaderStage> getStages()
	{
		if (stages == null)
		{
			stages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this,
					PipelinePackage.PUSH_CONSTANT_RANGE__STAGES);
		}
		return stages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getOffset()
	{
		return offset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOffset(int newOffset)
	{
		int oldOffset = offset;
		offset = newOffset;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				PipelinePackage.PUSH_CONSTANT_RANGE__OFFSET, oldOffset, offset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSize()
	{
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSize(int newSize)
	{
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				PipelinePackage.PUSH_CONSTANT_RANGE__SIZE, oldSize, size));
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
		case PipelinePackage.PUSH_CONSTANT_RANGE__STAGES:
			return getStages();
		case PipelinePackage.PUSH_CONSTANT_RANGE__OFFSET:
			return getOffset();
		case PipelinePackage.PUSH_CONSTANT_RANGE__SIZE:
			return getSize();
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
		case PipelinePackage.PUSH_CONSTANT_RANGE__STAGES:
			getStages().clear();
			getStages().addAll((Collection<? extends EShaderStage>) newValue);
			return;
		case PipelinePackage.PUSH_CONSTANT_RANGE__OFFSET:
			setOffset((Integer) newValue);
			return;
		case PipelinePackage.PUSH_CONSTANT_RANGE__SIZE:
			setSize((Integer) newValue);
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
		case PipelinePackage.PUSH_CONSTANT_RANGE__STAGES:
			getStages().clear();
			return;
		case PipelinePackage.PUSH_CONSTANT_RANGE__OFFSET:
			setOffset(OFFSET_EDEFAULT);
			return;
		case PipelinePackage.PUSH_CONSTANT_RANGE__SIZE:
			setSize(SIZE_EDEFAULT);
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
		case PipelinePackage.PUSH_CONSTANT_RANGE__STAGES:
			return stages != null && !stages.isEmpty();
		case PipelinePackage.PUSH_CONSTANT_RANGE__OFFSET:
			return offset != OFFSET_EDEFAULT;
		case PipelinePackage.PUSH_CONSTANT_RANGE__SIZE:
			return size != SIZE_EDEFAULT;
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
		result.append(" (stages: ");
		result.append(stages);
		result.append(", offset: ");
		result.append(offset);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //PushConstantRangeImpl
