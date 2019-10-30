/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EContentsEList;

import org.joml.Vector2ic;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.api.util.LTreeIterator;

import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.inference.InferencePackage;

import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.presentation.PresentationPackage;

import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.root.RootPackage;

import org.sheepy.lily.core.model.root.RootPackage.Literals;

import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesFactory;
import org.sheepy.lily.core.model.types.TypesPackage;

import org.sheepy.lily.core.model.variable.DirectVariableResolver;

import org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selector Panel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getContentObjects <em>Content Objects</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getVerticalRelative <em>Vertical Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getHorizontalRelative <em>Horizontal Relative</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getButtonSizePx <em>Button Size Px</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getSelectionR <em>Selection R</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getSelectionG <em>Selection G</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getSelectionB <em>Selection B</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#isPrintLabels <em>Print Labels</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getVariableResolver <em>Variable Resolver</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#getInputProvider <em>Input Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.nuklear.impl.SelectorPanelImpl#isVertical <em>Vertical</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SelectorPanelImpl extends LilyEObject implements SelectorPanel
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContentObjects() <em>Content Objects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<LObject> contentObjects;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final Vector2ic POSITION_EDEFAULT = (Vector2ic)TypesFactory.eINSTANCE.createFromString(TypesPackage.eINSTANCE.getVector2i(), "0;0");

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected Vector2ic position = POSITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EVerticalRelative VERTICAL_RELATIVE_EDEFAULT = EVerticalRelative.TOP;

	/**
	 * The cached value of the '{@link #getVerticalRelative() <em>Vertical Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerticalRelative()
	 * @generated
	 * @ordered
	 */
	protected EVerticalRelative verticalRelative = VERTICAL_RELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected static final EHorizontalRelative HORIZONTAL_RELATIVE_EDEFAULT = EHorizontalRelative.LEFT;

	/**
	 * The cached value of the '{@link #getHorizontalRelative() <em>Horizontal Relative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHorizontalRelative()
	 * @generated
	 * @ordered
	 */
	protected EHorizontalRelative horizontalRelative = HORIZONTAL_RELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getButtonSizePx() <em>Button Size Px</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButtonSizePx()
	 * @generated
	 * @ordered
	 */
	protected static final int BUTTON_SIZE_PX_EDEFAULT = 32;

	/**
	 * The cached value of the '{@link #getButtonSizePx() <em>Button Size Px</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButtonSizePx()
	 * @generated
	 * @ordered
	 */
	protected int buttonSizePx = BUTTON_SIZE_PX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectionR() <em>Selection R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionR()
	 * @generated
	 * @ordered
	 */
	protected static final int SELECTION_R_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSelectionR() <em>Selection R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionR()
	 * @generated
	 * @ordered
	 */
	protected int selectionR = SELECTION_R_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectionG() <em>Selection G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionG()
	 * @generated
	 * @ordered
	 */
	protected static final int SELECTION_G_EDEFAULT = 135;

	/**
	 * The cached value of the '{@link #getSelectionG() <em>Selection G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionG()
	 * @generated
	 * @ordered
	 */
	protected int selectionG = SELECTION_G_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectionB() <em>Selection B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionB()
	 * @generated
	 * @ordered
	 */
	protected static final int SELECTION_B_EDEFAULT = 255;

	/**
	 * The cached value of the '{@link #getSelectionB() <em>Selection B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionB()
	 * @generated
	 * @ordered
	 */
	protected int selectionB = SELECTION_B_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrintLabels() <em>Print Labels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrintLabels()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRINT_LABELS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrintLabels() <em>Print Labels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrintLabels()
	 * @generated
	 * @ordered
	 */
	protected boolean printLabels = PRINT_LABELS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariableResolver() <em>Variable Resolver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableResolver()
	 * @generated
	 * @ordered
	 */
	protected DirectVariableResolver variableResolver;

	/**
	 * The cached value of the '{@link #getInputProvider() <em>Input Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputProvider()
	 * @generated
	 * @ordered
	 */
	protected IInputProvider inputProvider;

	/**
	 * The default value of the '{@link #isVertical() <em>Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERTICAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVertical() <em>Vertical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVertical()
	 * @generated
	 * @ordered
	 */
	protected boolean vertical = VERTICAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectorPanelImpl()
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
		return NuklearPackage.Literals.SELECTOR_PANEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LObject> getContentObjects()
	{
		return contentObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContentObjects(EList<LObject> newContentObjects)
	{
		EList<LObject> oldContentObjects = contentObjects;
		contentObjects = newContentObjects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS, oldContentObjects, contentObjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Vector2ic getPosition()
	{
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPosition(Vector2ic newPosition)
	{
		Vector2ic oldPosition = position;
		position = newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EVerticalRelative getVerticalRelative()
	{
		return verticalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerticalRelative(EVerticalRelative newVerticalRelative)
	{
		EVerticalRelative oldVerticalRelative = verticalRelative;
		verticalRelative = newVerticalRelative == null ? VERTICAL_RELATIVE_EDEFAULT : newVerticalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE, oldVerticalRelative, verticalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EHorizontalRelative getHorizontalRelative()
	{
		return horizontalRelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalRelative(EHorizontalRelative newHorizontalRelative)
	{
		EHorizontalRelative oldHorizontalRelative = horizontalRelative;
		horizontalRelative = newHorizontalRelative == null ? HORIZONTAL_RELATIVE_EDEFAULT : newHorizontalRelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE, oldHorizontalRelative, horizontalRelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getButtonSizePx()
	{
		return buttonSizePx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setButtonSizePx(int newButtonSizePx)
	{
		int oldButtonSizePx = buttonSizePx;
		buttonSizePx = newButtonSizePx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX, oldButtonSizePx, buttonSizePx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSelectionR()
	{
		return selectionR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectionR(int newSelectionR)
	{
		int oldSelectionR = selectionR;
		selectionR = newSelectionR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__SELECTION_R, oldSelectionR, selectionR));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSelectionG()
	{
		return selectionG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectionG(int newSelectionG)
	{
		int oldSelectionG = selectionG;
		selectionG = newSelectionG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__SELECTION_G, oldSelectionG, selectionG));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSelectionB()
	{
		return selectionB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelectionB(int newSelectionB)
	{
		int oldSelectionB = selectionB;
		selectionB = newSelectionB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__SELECTION_B, oldSelectionB, selectionB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrintLabels()
	{
		return printLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrintLabels(boolean newPrintLabels)
	{
		boolean oldPrintLabels = printLabels;
		printLabels = newPrintLabels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__PRINT_LABELS, oldPrintLabels, printLabels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DirectVariableResolver getVariableResolver()
	{
		return variableResolver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableResolver(DirectVariableResolver newVariableResolver, NotificationChain msgs)
	{
		DirectVariableResolver oldVariableResolver = variableResolver;
		variableResolver = newVariableResolver;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER, oldVariableResolver, newVariableResolver);
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
	public void setVariableResolver(DirectVariableResolver newVariableResolver)
	{
		if (newVariableResolver != variableResolver)
		{
			NotificationChain msgs = null;
			if (variableResolver != null)
				msgs = ((InternalEObject)variableResolver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER, null, msgs);
			if (newVariableResolver != null)
				msgs = ((InternalEObject)newVariableResolver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER, null, msgs);
			msgs = basicSetVariableResolver(newVariableResolver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER, newVariableResolver, newVariableResolver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInputProvider getInputProvider()
	{
		return inputProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputProvider(IInputProvider newInputProvider, NotificationChain msgs)
	{
		IInputProvider oldInputProvider = inputProvider;
		inputProvider = newInputProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER, oldInputProvider, newInputProvider);
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
	public void setInputProvider(IInputProvider newInputProvider)
	{
		if (newInputProvider != inputProvider)
		{
			NotificationChain msgs = null;
			if (inputProvider != null)
				msgs = ((InternalEObject)inputProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER, null, msgs);
			if (newInputProvider != null)
				msgs = ((InternalEObject)newInputProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER, null, msgs);
			msgs = basicSetInputProvider(newInputProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER, newInputProvider, newInputProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVertical()
	{
		return vertical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertical(boolean newVertical)
	{
		boolean oldVertical = vertical;
		vertical = newVertical;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NuklearPackage.SELECTOR_PANEL__VERTICAL, oldVertical, vertical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends LObject> EList<T> createContainmentEList(final EClass targetEClass)
	{
		EList<T> res = null;
		final List<EStructuralFeature> unitRefs = new ArrayList<EStructuralFeature>();
		EList<EReference> _eAllContainments = this.eClass().getEAllContainments();
		for (final EReference ref : _eAllContainments)
		{
			EClassifier _eType = ref.getEType();
			boolean _isSuperTypeOf = targetEClass.isSuperTypeOf(((EClass) _eType));
			if (_isSuperTypeOf)
			{
				unitRefs.add(ref);
			}
		}
		boolean _isEmpty = unitRefs.isEmpty();
		if (_isEmpty)
		{
			res = ECollections.<T>emptyEList();
		}
		else
		{
			EContentsEList<T> _eContentsEList = new EContentsEList<T>(this, unitRefs);
			res = _eContentsEList;
		}
		return res;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LObject> lContents()
	{
		EList<LObject> _xblockexpression = null;
		{
			EList<LObject> _contentObjects = this.getContentObjects();
			boolean _tripleEquals = (_contentObjects == null);
			if (_tripleEquals)
			{
				this.setContentObjects(this.<LObject>createContainmentEList(Literals.LOBJECT));
			}
			_xblockexpression = this.getContentObjects();
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LObject lParent()
	{
		LObject _xifexpression = null;
		EObject _eContainer = this.eContainer();
		if ((_eContainer instanceof LObject))
		{
			EObject _eContainer_1 = this.eContainer();
			_xifexpression = ((LObject) _eContainer_1);
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LTreeIterator lAllContents()
	{
		return new LTreeIterator(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInferenceObject lInferenceObject()
	{
		return this;
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
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
				return basicSetVariableResolver(null, msgs);
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
				return basicSetInputProvider(null, msgs);
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
			case NuklearPackage.SELECTOR_PANEL__NAME:
				return getName();
			case NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS:
				return getContentObjects();
			case NuklearPackage.SELECTOR_PANEL__POSITION:
				return getPosition();
			case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE:
				return getVerticalRelative();
			case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE:
				return getHorizontalRelative();
			case NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX:
				return getButtonSizePx();
			case NuklearPackage.SELECTOR_PANEL__SELECTION_R:
				return getSelectionR();
			case NuklearPackage.SELECTOR_PANEL__SELECTION_G:
				return getSelectionG();
			case NuklearPackage.SELECTOR_PANEL__SELECTION_B:
				return getSelectionB();
			case NuklearPackage.SELECTOR_PANEL__PRINT_LABELS:
				return isPrintLabels();
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
				return getVariableResolver();
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
				return getInputProvider();
			case NuklearPackage.SELECTOR_PANEL__VERTICAL:
				return isVertical();
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
			case NuklearPackage.SELECTOR_PANEL__NAME:
				setName((String)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__POSITION:
				setPosition((Vector2ic)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE:
				setVerticalRelative((EVerticalRelative)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative((EHorizontalRelative)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX:
				setButtonSizePx((Integer)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_R:
				setSelectionR((Integer)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_G:
				setSelectionG((Integer)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_B:
				setSelectionB((Integer)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__PRINT_LABELS:
				setPrintLabels((Boolean)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
				setVariableResolver((DirectVariableResolver)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
				setInputProvider((IInputProvider)newValue);
				return;
			case NuklearPackage.SELECTOR_PANEL__VERTICAL:
				setVertical((Boolean)newValue);
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
			case NuklearPackage.SELECTOR_PANEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS:
				setContentObjects((EList<LObject>)null);
				return;
			case NuklearPackage.SELECTOR_PANEL__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE:
				setVerticalRelative(VERTICAL_RELATIVE_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE:
				setHorizontalRelative(HORIZONTAL_RELATIVE_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX:
				setButtonSizePx(BUTTON_SIZE_PX_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_R:
				setSelectionR(SELECTION_R_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_G:
				setSelectionG(SELECTION_G_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_B:
				setSelectionB(SELECTION_B_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__PRINT_LABELS:
				setPrintLabels(PRINT_LABELS_EDEFAULT);
				return;
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
				setVariableResolver((DirectVariableResolver)null);
				return;
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
				setInputProvider((IInputProvider)null);
				return;
			case NuklearPackage.SELECTOR_PANEL__VERTICAL:
				setVertical(VERTICAL_EDEFAULT);
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
			case NuklearPackage.SELECTOR_PANEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS:
				return contentObjects != null;
			case NuklearPackage.SELECTOR_PANEL__POSITION:
				return POSITION_EDEFAULT == null ? position != null : !POSITION_EDEFAULT.equals(position);
			case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE:
				return verticalRelative != VERTICAL_RELATIVE_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE:
				return horizontalRelative != HORIZONTAL_RELATIVE_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__BUTTON_SIZE_PX:
				return buttonSizePx != BUTTON_SIZE_PX_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_R:
				return selectionR != SELECTION_R_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_G:
				return selectionG != SELECTION_G_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__SELECTION_B:
				return selectionB != SELECTION_B_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__PRINT_LABELS:
				return printLabels != PRINT_LABELS_EDEFAULT;
			case NuklearPackage.SELECTOR_PANEL__VARIABLE_RESOLVER:
				return variableResolver != null;
			case NuklearPackage.SELECTOR_PANEL__INPUT_PROVIDER:
				return inputProvider != null;
			case NuklearPackage.SELECTOR_PANEL__VERTICAL:
				return vertical != VERTICAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == LObject.class)
		{
			switch (derivedFeatureID)
			{
				case NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS: return RootPackage.LOBJECT__CONTENT_OBJECTS;
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (derivedFeatureID)
			{
				case NuklearPackage.SELECTOR_PANEL__POSITION: return PresentationPackage.IPOSITION_ELEMENT__POSITION;
				case NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE;
				case NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE: return PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == LObject.class)
		{
			switch (baseFeatureID)
			{
				case RootPackage.LOBJECT__CONTENT_OBJECTS: return NuklearPackage.SELECTOR_PANEL__CONTENT_OBJECTS;
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (baseFeatureID)
			{
				case PresentationPackage.IPOSITION_ELEMENT__POSITION: return NuklearPackage.SELECTOR_PANEL__POSITION;
				case PresentationPackage.IPOSITION_ELEMENT__VERTICAL_RELATIVE: return NuklearPackage.SELECTOR_PANEL__VERTICAL_RELATIVE;
				case PresentationPackage.IPOSITION_ELEMENT__HORIZONTAL_RELATIVE: return NuklearPackage.SELECTOR_PANEL__HORIZONTAL_RELATIVE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
	{
		if (baseClass == IInferenceObject.class)
		{
			switch (baseOperationID)
			{
				case InferencePackage.IINFERENCE_OBJECT___LINFERENCE_OBJECT: return NuklearPackage.SELECTOR_PANEL___LINFERENCE_OBJECT;
				default: return -1;
			}
		}
		if (baseClass == LObject.class)
		{
			switch (baseOperationID)
			{
				case RootPackage.LOBJECT___CREATE_CONTAINMENT_ELIST__ECLASS: return NuklearPackage.SELECTOR_PANEL___CREATE_CONTAINMENT_ELIST__ECLASS;
				case RootPackage.LOBJECT___LCONTENTS: return NuklearPackage.SELECTOR_PANEL___LCONTENTS;
				case RootPackage.LOBJECT___LPARENT: return NuklearPackage.SELECTOR_PANEL___LPARENT;
				case RootPackage.LOBJECT___LALL_CONTENTS: return NuklearPackage.SELECTOR_PANEL___LALL_CONTENTS;
				default: return -1;
			}
		}
		if (baseClass == IUIElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		if (baseClass == IPositionElement.class)
		{
			switch (baseOperationID)
			{
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case NuklearPackage.SELECTOR_PANEL___CREATE_CONTAINMENT_ELIST__ECLASS:
				return createContainmentEList((EClass)arguments.get(0));
			case NuklearPackage.SELECTOR_PANEL___LCONTENTS:
				return lContents();
			case NuklearPackage.SELECTOR_PANEL___LPARENT:
				return lParent();
			case NuklearPackage.SELECTOR_PANEL___LALL_CONTENTS:
				return lAllContents();
			case NuklearPackage.SELECTOR_PANEL___LINFERENCE_OBJECT:
				return lInferenceObject();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", contentObjects: ");
		result.append(contentObjects);
		result.append(", position: ");
		result.append(position);
		result.append(", verticalRelative: ");
		result.append(verticalRelative);
		result.append(", horizontalRelative: ");
		result.append(horizontalRelative);
		result.append(", buttonSizePx: ");
		result.append(buttonSizePx);
		result.append(", selectionR: ");
		result.append(selectionR);
		result.append(", selectionG: ");
		result.append(selectionG);
		result.append(", selectionB: ");
		result.append(selectionB);
		result.append(", printLabels: ");
		result.append(printLabels);
		result.append(", vertical: ");
		result.append(vertical);
		result.append(')');
		return result.toString();
	}

} //SelectorPanelImpl
